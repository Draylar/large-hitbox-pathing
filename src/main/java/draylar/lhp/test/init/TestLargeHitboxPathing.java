package draylar.lhp.test.init;

import draylar.lhp.test.entity.FixedExampleEntity;
import draylar.lhp.test.entity.UnfixedExampleEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TestLargeHitboxPathing implements ModInitializer {

    public static final EntityType<UnfixedExampleEntity> UNFIXED_EXAMPLE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("test", "unfixed_example_entity"),
            FabricEntityTypeBuilder.createMob()
                    .spawnGroup(SpawnGroup.MISC)
                    .defaultAttributes(UnfixedExampleEntity::createBoxAttributes)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f))
                    .entityFactory(UnfixedExampleEntity::new)
                    .build());

    public static final EntityType<FixedExampleEntity> FIXED_EXAMPLE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("test", "fixed_example_entity"),
            FabricEntityTypeBuilder.createMob()
                    .spawnGroup(SpawnGroup.MISC)
                    .defaultAttributes(UnfixedExampleEntity::createBoxAttributes)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.5f))
                    .entityFactory(FixedExampleEntity::new)
                    .build());


    @Override
    public void onInitialize() {

    }
}
