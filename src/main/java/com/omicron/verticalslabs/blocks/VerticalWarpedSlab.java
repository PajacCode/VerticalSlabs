
    package com.omicron.verticalslabs.blocks;

import com.omicron.verticalslabs.items.VerticalWarpedSlabItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class VerticalWarpedSlab extends VerticalSlabBase<VerticalWarpedSlab> {

    public VerticalWarpedSlab() {
        super(
                Properties.of(Material.WOOD)
                .strength(2.0f, 3.0f)
                .harvestTool(ToolType.AXE)
                .sound(SoundType.WOOD)
        );
    }


}

    