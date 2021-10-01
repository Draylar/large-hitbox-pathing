package draylar.lhp.test.entity;

import draylar.lhp.api.LargePathing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class FixedExampleEntity extends UnfixedExampleEntity implements LargePathing {

    public FixedExampleEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
