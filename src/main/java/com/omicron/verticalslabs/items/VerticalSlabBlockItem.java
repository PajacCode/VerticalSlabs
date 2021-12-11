package com.omicron.verticalslabs.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

import static com.omicron.verticalslabs.blocks.VerticalSlabBase.FULL;

    public class VerticalSlabBlockItem extends BlockItem {
    public VerticalSlabBlockItem(Block p_i48527_1_) {
        super(p_i48527_1_, new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        BlockPos pos =  context.getClickedPos().relative(context.getClickedFace());
        PlayerEntity player = context.getPlayer();

        if (context.getLevel().getBlockState(pos).getBlock().getClass().isInstance(this.getBlock()) &&
                !context.getLevel().getBlockState(pos).getValue(FULL)) {
            context.getLevel().setBlock(pos, context.getLevel().getBlockState(pos).setValue(FULL, true), 3);
            if (!player.isCreative()) player.getItemInHand(context.getHand()).setCount(player.getItemInHand(context.getHand()).getCount()-1);
            return ActionResultType.SUCCESS;
        }
        return super.useOn(context);
    }
}
