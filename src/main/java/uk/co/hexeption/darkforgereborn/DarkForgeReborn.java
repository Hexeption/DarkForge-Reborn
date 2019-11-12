package uk.co.hexeption.darkforgereborn;

import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.hexeption.darkforgereborn.event.EventCaller;
import uk.co.hexeption.darkforgereborn.managers.ModManager;
import uk.co.hexeption.darkforgereborn.util.LogHelper;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("darkforgereborn")
public class DarkForgeReborn {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    // Instance
    public static final DarkForgeReborn INSTANCE = new DarkForgeReborn();

    // Event
    public final EventBus eventBus = new EventManager();

    // Mod Manager
    public final ModManager modManager = new ModManager();

    public void start() {
        LogHelper.section(String.format("Starting %s v%s", ClientInfo.MOD_NAME, ClientInfo.MOD_BUILD));
        eventBus.subscribe(new EventCaller());
        LogHelper.section("Loading Mods");
        modManager.init();
        LogHelper.section("Loading Commands");
        LogHelper.section("Loading Fonts");
        LogHelper.section("Loading Huds");
        LogHelper.section("Loading Tabs");
        LogHelper.section("Loading Configs");

        LogHelper.endSection();
        Runtime.getRuntime().addShutdownHook(new Thread(this::end));
    }

    private void end() {
        LogHelper.section(String.format("Stopping %s v%s", ClientInfo.MOD_NAME, ClientInfo.MOD_BUILD));

        LogHelper.section("Saving Mods");
        LogHelper.section("Saving Alts");
        LogHelper.section("Saving Friends");

        LogHelper.endSection();
    }

}
