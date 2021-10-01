package draylar.lhp.test.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class BoxRenderer extends EntityRenderer<LivingEntity> {

    public static final ItemStack BLOCK = new ItemStack(Items.BLACK_CONCRETE);

    public BoxRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(LivingEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);

        matrices.push();
        matrices.translate(0, .75, 0);
        matrices.scale(3, 3, 3);
        matrices.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevBodyYaw, entity.bodyYaw)));
        MinecraftClient.getInstance().getItemRenderer().renderItem(BLOCK, ModelTransformation.Mode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(LivingEntity entity) {
        return null;
    }
}
