package draylar.lhp;

import draylar.lhp.test.client.BoxRenderer;
import draylar.lhp.test.init.TestLargeHitboxPathing;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class LargeHitboxPathingClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            EntityRendererRegistry.register(TestLargeHitboxPathing.UNFIXED_EXAMPLE_ENTITY, BoxRenderer::new);
            EntityRendererRegistry.register(TestLargeHitboxPathing.FIXED_EXAMPLE_ENTITY, BoxRenderer::new);
        }
    }
}
