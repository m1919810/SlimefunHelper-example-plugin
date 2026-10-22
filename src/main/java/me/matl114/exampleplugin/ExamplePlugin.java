package me.matl114.exampleplugin;

import me.matl114.exampleplugin.modules.ExampleModule;
import me.matl114.hacks.api.ModuleGroup;
import me.matl114.managers.config.Config;
import me.matl114.managers.config.ConfigLoader;
import me.matl114.plugins.SlimefunHelperPlugin;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

public final class ExamplePlugin implements SlimefunHelperPlugin {
    public static final String MOD_ID = "slimefunhelperpluginexample";
    public static Config EXAMPLE_CONFIG;
    public static Config EXAMPLE_CONFIG_2;

    @Override
    public void onConfigBootstrap() {
        EXAMPLE_CONFIG = ConfigLoader.loadRuntimeConfig("example_config.yml", "example config").markForSave();
        EXAMPLE_CONFIG_2 = ConfigLoader.loadRuntimeConfig("example_config_2.yml", "example config 2").markForSave();
        registerConfig(EXAMPLE_CONFIG_2);
    }

    @Override
    public void onListenerBootstrap() {}

    @Override
    public void onModuleBootstrap() {
        ModuleGroup group = new ModuleGroup("Example");
        group.registerFactories(manager -> new ExampleModule().register(manager));
        registerModuleGroup(group);
    }

    @Override
    public void postInitialize() {}

    @Override
    public String getPluginId() {
        return MOD_ID;
    }

    @Override
    public ModContainer getContainer() {
        return FabricLoader.getInstance()
                .getModContainer(MOD_ID)
                .orElseThrow(() -> new IllegalStateException("Example plugin mod container not found."));
    }
}
