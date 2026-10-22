package me.matl114.exampleplugin.modules;

import me.matl114.exampleplugin.ExamplePlugin;
import me.matl114.hacks.api.BaseModule;
import me.matl114.hacks.api.ModulePath;
import me.matl114.managers.config.FlagRef;

public final class ExampleModule extends BaseModule {
    public final ModulePath examplePath = makePath(ExamplePlugin.EXAMPLE_CONFIG, "example-module");
    public final ModulePath examplePath2 = makePath(ExamplePlugin.EXAMPLE_CONFIG_2, "example-module");
    public final FlagRef enabled = flagBuilder(examplePath.addEnable()).build();
    public final FlagRef option = flagBuilder(examplePath2.add("option")).build();

    public ExampleModule() {
        super("ExampleModule");
    }
}
