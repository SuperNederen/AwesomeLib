package org.supernederen.awesomelib.library.events;

import com.google.common.reflect.ClassPath;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.lang.reflect.Method;

/**
 * A helper class that allows you to register all listeners in your plugin with the @Listener annotation.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.1.0
 */
public class Listeners implements org.bukkit.event.Listener {
    public void register() {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (!plugin.getName().equals("AwesomeLib")) {
                if (!plugin.getDescription().getDepend().contains("AwesomeLib") && !plugin.getDescription().getSoftDepend().contains("AwesomeLib")) continue;
            }
            try {
                for (ClassPath.ClassInfo classInfo : ClassPath.from(plugin.getClass().getClassLoader()).getTopLevelClassesRecursive(plugin.getClass().getPackage().getName())) {
                    try {
                        classInfo.load().getDeclaredMethods();
                    } catch (NoClassDefFoundError e) {
                        continue;
                    }
                    for (Method method : classInfo.load().getDeclaredMethods()) {
                        if (method.isAnnotationPresent(Listener.class)) {
                            Listener annotation = method.getAnnotation(Listener.class);
                            if (annotation.doNotRegister()) continue;
                            RegisteredListener rl = new RegisteredListener(this, (listener, event) -> {
                                try {
                                    method.invoke(null, event);
                                } catch (IllegalArgumentException ignored) {
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }, annotation.priority(), plugin, annotation.ignoreCancelled());
                            try {
                                HandlerList handlers = (HandlerList) method.getParameters()[0].getType().getDeclaredMethod("getHandlerList").invoke(null);
                                handlers.register(rl);
                            } catch (Exception e) {
                                try {
                                    HandlerList handlers = (HandlerList) method.getParameters()[0].getType().getSuperclass().getDeclaredMethod("getHandlerList").invoke(null);
                                    handlers.register(rl);
                                } catch (Exception e1) {
                                    plugin.getLogger().warning("The event " + method.getParameters()[0].getType().getSimpleName() + " does not have a getHandlerList() method!");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
