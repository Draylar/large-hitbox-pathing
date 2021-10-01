package draylar.lhp.test.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.util.EnumSet;

public class UnfixedExampleEntity extends PathAwareEntity {

    public UnfixedExampleEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        goalSelector.add(0, new MeleeAttackGoal(this, 0.5f, false));
        targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder createBoxAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0D);
    }

    public static class BoxFollowGoal extends Goal {

        private final MobEntity mob;
        private LivingEntity target;

        public BoxFollowGoal(MobEntity mob) {
            this.mob = mob;
            setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        }

        @Override
        public boolean canStart() {
            if (mob.getTarget() == null) {
                return false;
            } else {
                this.target = mob.getTarget();
                return true;
            }
        }

        @Override
        public boolean shouldContinue() {
            if (!target.isAlive()) {
                return false;
            } else if (mob.squaredDistanceTo(target) > 225.0D) {
                return false;
            } else {
                return !mob.getNavigation().isIdle() || canStart();
            }
        }

        @Override
        public void stop() {
            target = null;
            mob.getNavigation().stop();
        }

        @Override
        public void tick() {
            mob.getLookControl().lookAt(target, 30.0F, 30.0F);
            mob.getNavigation().startMovingTo(target, 0.3f);
        }
    }
}
