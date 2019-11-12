package uk.co.hexeption.darkforgereborn.mod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.LinkedHashMap;
import java.util.Map;
import me.zero.alpine.listener.Listenable;
import org.lwjgl.glfw.GLFW;
import uk.co.hexeption.darkforgereborn.DarkForgeReborn;
import uk.co.hexeption.darkforgereborn.IMC;
import uk.co.hexeption.darkforgereborn.mod.options.Option;
import uk.co.hexeption.darkforgereborn.mod.options.Option.Type;
import uk.co.hexeption.darkforgereborn.mod.options.ValueString;
import uk.co.hexeption.darkforgereborn.util.LogHelper;

/**
 * Mod
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 12/11/2019 - 11:47 am
 */
public class Mod implements Listenable, IMC {

    private String name = getClass().getAnnotation(ModInfo.class).name();
    private String description = getClass().getAnnotation(ModInfo.class).description();
    private Category category = getClass().getAnnotation(ModInfo.class).category();
    private int bind = getClass().getAnnotation(ModInfo.class).bind();
    private boolean state;
    public Map<String, Option> options = new LinkedHashMap<>();

    public Mod() {

        options.put("keybind", new Option("Keybind", "Module toggle keybind", new ValueString(GLFW.glfwGetKeyName(bind, GLFW.glfwGetKeyScancode(bind))), Type.KEYBIND));
    }

    public boolean getState() {

        return state;
    }

    public void setState(boolean state) {

        onToggle();
        if (state) {
            this.state = true;
            onEnable();
            DarkForgeReborn.INSTANCE.eventBus.subscribe(this);
        } else {
            this.state = false;
            onDisable();
            DarkForgeReborn.INSTANCE.eventBus.unsubscribe(this);
        }


    }

    public void toggle() {

        setState(!this.state);
    }

    public void onToggle() {

    }

    public void onDisable() {
        LogHelper.info(String.format("Disabling %s", name));
    }

    public void onEnable() {
        LogHelper.info(String.format("Enabling %s", name));
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public int getBind() {

        return bind;
    }

    public void setBind(int bind) {

        this.bind = bind;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ModInfo {

        String name();

        String description();

        Category category();

        int bind() default 0;
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enabled {

    }


}
