package draylar.lhp;

import draylar.lhp.test.init.TestLargeHitboxPathing;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class LargeHitboxPathing implements ModInitializer {

    @Override
    public void onInitialize() {
        if(FabricLoader.getInstance().isDevelopmentEnvironment()) {
            new TestLargeHitboxPathing().onInitialize();
        }
    }
}
