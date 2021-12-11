package com.omicron.verticalslabs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class VerticalSlabBase<T extends VerticalSlabBase<T>> extends Block implements IWaterLoggable {

    T blockType;

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (hit.getDirection().getOpposite() == state.getValue(FACING) &&
                !state.getValue(FULL) &&
                player.getItemInHand(handIn).getItem() instanceof BlockItem && ((BlockItem) player.getItemInHand(handIn).getItem()).getBlock().getClass().isInstance(blockType)) {
            worldIn.setBlock(pos, state.setValue(FULL, true), 3);
            if (!player.isCreative()) player.getItemInHand(handIn).setCount(player.getItemInHand(handIn).getCount()-1);
            return ActionResultType.SUCCESS;
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    //straight 0
    //inner left 1
    //inner right 2
    //outer left 3
    //outer right 4

    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty FULL = BooleanProperty.create("full");
    public  static final IntegerProperty SHAPE = IntegerProperty.create("shape", 0, 4);

    // north facing
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 16, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_NIL = Stream.of(
            Block.box(0, 0, 0, 16, 16, 8),
            Block.box(0, 0, 8, 8, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_NIR = Stream.of(
            Block.box(0, 16, 0, 16, 0, 8),
            Block.box(8, 0, 0, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_NOL = Stream.of(
            Block.box(0, 0, 0, 8, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_NOR = Stream.of(
            Block.box(8, 0, 0, 16, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    // south facing
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 0, 8, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_SIL = Stream.of(
            Block.box(0, 0, 8, 16, 16, 16),
            Block.box(0, 0, 0, 8, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_SIR = Stream.of(
            Block.box(0, 0, 8, 16, 16, 16),
            Block.box(8, 0, 0, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_SOL = Stream.of(
            Block.box(0, 0, 8, 8, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_SOR = Stream.of(
            Block.box(8, 0, 8, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    //west facing
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(0, 0, 0, 8, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_WIL = Stream.of(
            Block.box(0, 0, 8, 8, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_WIR = Stream.of(
            Block.box(0, 0, 0, 8, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_WOL = Stream.of(
            Block.box(0, 0, 0, 8, 16, 16),
            Block.box(8, 0, 8, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_WOR = Stream.of(
            Block.box(0, 0, 0, 8, 16, 16),
            Block.box(8, 0, 0, 16, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    // east facing
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(8, 0, 0, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_EIL = Stream.of(
            Block.box(8, 0, 8, 16, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_EIR = Stream.of(
            Block.box(8, 0, 0, 16, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_EOL = Stream.of(
            Block.box(8, 0, 0, 16, 16, 16),
            Block.box(0, 0, 8, 8, 16, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_EOR = Stream.of(
            Block.box(8, 0, 0, 16, 16, 16),
            Block.box(0, 0, 0, 8, 16, 8))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_FULL = Stream.of(
            Block.box(0, 16, 0, 16, 0, 16))
            .reduce((v1, v2) -> {
                return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    public VerticalSlabBase(Properties properties) {
        super(properties.noOcclusion().dynamicShape());
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FULL, false)
                .setValue(SHAPE, 0)
                .setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState checkedState = checkAdjacentBlocks(context.getLevel(), context.getClickedPos(),
                this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()), 0);

        if (context.getLevel().getBlockState(context.getClickedPos()).getFluidState().getType() instanceof WaterFluid &&
                context.getLevel().getBlockState(context.getClickedPos()).getFluidState().isSource())
            checkedState = checkedState.setValue(BlockStateProperties.WATERLOGGED, true);

        return checkedState;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.getValue(FULL)) return SHAPE_FULL;
        switch (state.getValue(FACING)) {
            case NORTH:
                if (state.getValue(SHAPE) == 1) return SHAPE_NIL;
                else if (state.getValue(SHAPE) == 2) return SHAPE_NIR;
                else if (state.getValue(SHAPE) == 3) return SHAPE_NOL;
                else if (state.getValue(SHAPE) == 4) return SHAPE_NOR;
                return SHAPE_N;
            case SOUTH:
                if (state.getValue(SHAPE) == 1) return SHAPE_SIL;
                else if (state.getValue(SHAPE) == 2) return SHAPE_SIR;
                else if (state.getValue(SHAPE) == 3) return SHAPE_SOL;
                else if (state.getValue(SHAPE) == 4) return SHAPE_SOR;
                return SHAPE_S;
            case EAST:
                if (state.getValue(SHAPE) == 1) return SHAPE_EOR;
                else if (state.getValue(SHAPE) == 2) return SHAPE_EOL;
                else if (state.getValue(SHAPE) == 3) return SHAPE_EIR;
                else if (state.getValue(SHAPE) == 4) return SHAPE_EIL;
                return SHAPE_E;
            case WEST:
                if (state.getValue(SHAPE) == 1) return SHAPE_WOR;
                else if (state.getValue(SHAPE) == 2) return SHAPE_WOL;
                else if (state.getValue(SHAPE) == 3) return SHAPE_WIR;
                else if (state.getValue(SHAPE) == 4) return SHAPE_WIL;
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, FULL, SHAPE, BlockStateProperties.WATERLOGGED);
    }

    private void updateNeighbours(World world, BlockPos pos, boolean blockBeingDestroyed) {
        BlockState north = world.getBlockState(pos.offset(Direction.NORTH.getNormal()));
        BlockState south = world.getBlockState(pos.offset(Direction.SOUTH.getNormal()));
        BlockState west = world.getBlockState(pos.offset(Direction.WEST.getNormal()));
        BlockState east = world.getBlockState(pos.offset(Direction.EAST.getNormal()));

        if (north.getBlock() instanceof VerticalSlabBase) {
            if (!blockBeingDestroyed)world.setBlock(pos.relative(Direction.NORTH),
                    checkAdjacentBlocks(world, pos.relative(Direction.NORTH), north, 0), 3);
            else world.setBlock(pos.relative(Direction.NORTH),
                    checkAdjacentBlocks(world, pos.relative(Direction.NORTH), north, 2), 3);
        }
        if (south.getBlock() instanceof VerticalSlabBase) {
            if (!blockBeingDestroyed) world.setBlock(pos.relative(Direction.SOUTH),
                    checkAdjacentBlocks(world, pos.relative(Direction.SOUTH), south, 0), 3);
            else world.setBlock(pos.relative(Direction.SOUTH),
                    checkAdjacentBlocks(world, pos.relative(Direction.SOUTH), south, 1), 3);
        }
        if (west.getBlock() instanceof VerticalSlabBase) {
            if (!blockBeingDestroyed) world.setBlock(pos.relative(Direction.WEST),
                    checkAdjacentBlocks(world, pos.relative(Direction.WEST), west, 0), 3);
            else world.setBlock(pos.relative(Direction.WEST),
                    checkAdjacentBlocks(world, pos.relative(Direction.WEST), west, 4), 3);
        }
        if (east.getBlock() instanceof VerticalSlabBase) {
            if (!blockBeingDestroyed) world.setBlock(pos.relative(Direction.EAST),
                    checkAdjacentBlocks(world, pos.relative(Direction.EAST), east, 0), 3);
            else world.setBlock(pos.relative(Direction.EAST),
                    checkAdjacentBlocks(world, pos.relative(Direction.EAST), east, 3), 3);
        }
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        updateNeighbours(world, pos, false);
        super.setPlacedBy(world, pos, state, entity, stack);
    }

    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        updateNeighbours(world, pos, true);
        super.playerWillDestroy(world, pos, state, player);
    }

    public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return !state.getValue(FULL) && !state.getValue(BlockStateProperties.WATERLOGGED) && fluidIn instanceof WaterFluid;
    }

    @Override
    public Fluid takeLiquid(IWorld world, BlockPos pos, BlockState state) {
        if(state.getValue(BlockStateProperties.WATERLOGGED)) {
            world.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, false), 3);
            return Fluids.WATER;
        }
        return Fluids.EMPTY;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(BlockStateProperties.WATERLOGGED)) return Fluids.WATER.getSource(true);
        else return Fluids.EMPTY.defaultFluidState();
    }

    @Deprecated
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, World worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.getValue(BlockStateProperties.WATERLOGGED)) {
            this.placeLiquid(worldIn, currentPos, stateIn, Fluids.WATER.getSource(false));
        }
        worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    private BlockState checkAdjacentBlocks(World world, BlockPos pos, BlockState center, int beingDestroyed) {
        /*
        beingDestroyed
        0 none
        1 north
        2 south
        3 west
        4 east
         */

        if (center.getValue(FULL)) return center;

        BlockState north = world.getBlockState(pos.relative(Direction.NORTH));
        if (beingDestroyed == 1) north = north.setValue(FULL, true);
        BlockState south = world.getBlockState(pos.relative(Direction.SOUTH));
        if (beingDestroyed == 2) south = south.setValue(FULL, true);
        BlockState west = world.getBlockState(pos.relative(Direction.WEST));
        if (beingDestroyed == 3) west = west.setValue(FULL, true);
        BlockState east = world.getBlockState(pos.relative(Direction.EAST));
        if (beingDestroyed == 4) east = east.setValue(FULL, true);

        //placing northwards
        if (center.getValue(FACING) == Direction.NORTH &&
                !((west.getBlock() instanceof VerticalSlabBase && !west.getValue(FULL) &&(west.getValue(FACING) == Direction.NORTH &&
                        (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 1 || west.getValue(SHAPE) == 4) ||
                        west.getValue(FACING) == Direction.WEST && (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 1))) &&
                (east.getBlock() instanceof VerticalSlabBase && !east.getValue(FULL) && (east.getValue(FACING) == Direction.NORTH &&
                        (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 2 || east.getValue(SHAPE) == 3)||
                        east.getValue(FACING) == Direction.EAST && (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 1))))
        ) {
            if (north.getBlock() instanceof VerticalSlabBase && !north.getValue(FULL)) {
                if (north.getValue(FACING) == Direction.WEST) {
                    if (east.getBlock() instanceof VerticalSlabBase && (
                        (east.getValue(FACING) == Direction.NORTH && (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 3 || east.getValue(SHAPE) == 2 || east.getValue(SHAPE) == 4)) ||
                        (east.getValue(FACING) == Direction.EAST && (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 1))
                    )) {
                        if (south.getBlock() instanceof VerticalSlabBase && !south.getValue(FULL)) {
                            if (south.getValue(FACING) == Direction.WEST) return center.setValue(SHAPE, 1);
                            else if (south.getValue(FACING) == Direction.EAST) return center.setValue(SHAPE, 2);
                        }
                        return  center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 3);
                }
                if (north.getValue(FACING) == Direction.EAST) {
                    if (west.getBlock() instanceof VerticalSlabBase && (
                        (west.getValue(FACING) == Direction.NORTH && (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 4 || west.getValue(SHAPE) == 1 || west.getValue(SHAPE) == 3)) ||
                        (west.getValue(FACING) == Direction.WEST && (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 1))
                    )) {
                        if (south.getBlock() instanceof VerticalSlabBase && !south.getValue(FULL)) {
                            if (south.getValue(FACING) == Direction.WEST) return center.setValue(SHAPE, 1);
                            else if (south.getValue(FACING) == Direction.EAST) return center.setValue(SHAPE, 2);
                        }
                        return  center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 4);
                }
            }
            if (south.getBlock() instanceof VerticalSlabBase && !south.getValue(FULL)) {
                if (south.getValue(FACING) == Direction.WEST) return center.setValue(SHAPE, 1);
                else if (south.getValue(FACING) == Direction.EAST) return center.setValue(SHAPE, 2);
            }
        }
        //placing southwards
        else if (center.getValue(FACING) == Direction.SOUTH &&
                !((west.getBlock() instanceof VerticalSlabBase && !west.getValue(FULL) &&(west.getValue(FACING) == Direction.SOUTH &&
                        (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 2 || west.getValue(SHAPE) == 3) ||
                        west.getValue(FACING) == Direction.WEST && (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 2))) &&
                (east.getBlock() instanceof VerticalSlabBase && !east.getValue(FULL) && (east.getValue(FACING) == Direction.SOUTH &&
                        (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 1 || east.getValue(SHAPE) == 4)||
                        east.getValue(FACING) == Direction.EAST && (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 2))))
        ) {
            if (south.getBlock() instanceof VerticalSlabBase && !south.getValue(FULL)) {
                if (south.getValue(FACING) == Direction.WEST){
                    if (east.getBlock() instanceof VerticalSlabBase && (
                        (east.getValue(FACING) == Direction.SOUTH && (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 2 || east.getValue(SHAPE) == 3 || east.getValue(SHAPE) == 4)) ||
                        (east.getValue(FACING) == Direction.EAST && (east.getValue(SHAPE) == 0 || east.getValue(SHAPE) == 2))
                    )) {
                        if (north.getBlock() instanceof VerticalSlabBase && !north.getValue(FULL)) {
                            if (north.getValue(FACING) == Direction.WEST) return center.setValue(SHAPE, 1);
                            else if (north.getValue(FACING) == Direction.EAST) return center.setValue(SHAPE, 2);
                        }
                        return center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 3);
                }
                if (south.getValue(FACING) == Direction.EAST) {
                    if (west.getBlock() instanceof VerticalSlabBase && (
                        (west.getValue(FACING) == Direction.SOUTH && (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 1 || west.getValue(SHAPE) == 4 || west.getValue(SHAPE) == 3)) ||
                        (west.getValue(FACING) == Direction.WEST && (west.getValue(SHAPE) == 0 || west.getValue(SHAPE) == 2))
                    )) {
                        if (north.getBlock() instanceof VerticalSlabBase && !north.getValue(FULL)) {
                            if (north.getValue(FACING) == Direction.WEST) return center.setValue(SHAPE, 1);
                            else if (north.getValue(FACING) == Direction.EAST) return center.setValue(SHAPE, 2);
                        }
                        return center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 4);
                }
            }
            if (north.getBlock() instanceof VerticalSlabBase && !north.getValue(FULL)) {
                if (north.getValue(FACING) == Direction.WEST) return center.setValue(SHAPE, 1);
                else if (north.getValue(FACING) == Direction.EAST) return center.setValue(SHAPE, 2);
            }
        }
        //placing westwards
        else if (center.getValue(FACING) == Direction.WEST &&
                !((south.getBlock() instanceof VerticalSlabBase && !south.getValue(FULL) &&(south.getValue(FACING) == Direction.WEST &&
                        (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 1 || south.getValue(SHAPE) == 4) ||
                        south.getValue(FACING) == Direction.SOUTH && (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 1))) &&
                (north.getBlock() instanceof VerticalSlabBase && !north.getValue(FULL) && (north.getValue(FACING) == Direction.WEST &&
                        (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 2 || north.getValue(SHAPE) == 3)||
                        north.getValue(FACING) == Direction.NORTH && (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 1))))
        ) {
            if (west.getBlock() instanceof VerticalSlabBase && !west.getValue(FULL)) {
                if (west.getValue(FACING) == Direction.NORTH) {
                    if (south.getBlock() instanceof VerticalSlabBase && (
                        (south.getValue(FACING) == Direction.WEST && (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 2 || south.getValue(SHAPE) == 3 || south.getValue(SHAPE) == 4)) ||
                        (south.getValue(FACING) == Direction.SOUTH && (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 1))
                    )){
                        if (east.getBlock() instanceof VerticalSlabBase && !east.getValue(FULL)) {
                            if (east.getValue(FACING) == Direction.NORTH) return center.setValue(SHAPE, 1);
                            else if (east.getValue(FACING) == Direction.SOUTH) return center.setValue(SHAPE, 2);
                        }
                        return center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 3);
                }
                if (west.getValue(FACING) == Direction.SOUTH) {
                    if (north.getBlock() instanceof VerticalSlabBase && (
                        (north.getValue(FACING) == Direction.WEST && (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 1 || north.getValue(SHAPE) == 4 || north.getValue(SHAPE) == 3)) ||
                        (north.getValue(FACING) == Direction.NORTH && (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 1))
                    )){
                        if (east.getBlock() instanceof VerticalSlabBase && !east.getValue(FULL)) {
                            if (east.getValue(FACING) == Direction.NORTH) return center.setValue(SHAPE, 1);
                            else if (east.getValue(FACING) == Direction.SOUTH) return center.setValue(SHAPE, 2);
                        }
                        return center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 4);
                }
            }
            if (east.getBlock() instanceof VerticalSlabBase && !east.getValue(FULL)) {
                if (east.getValue(FACING) == Direction.NORTH) return center.setValue(SHAPE, 1);
                else if (east.getValue(FACING) == Direction.SOUTH) return center.setValue(SHAPE, 2);
            }
        }
        //placing eastwards
        else if (center.getValue(FACING) == Direction.EAST &&
                !((south.getBlock() instanceof VerticalSlabBase && !south.getValue(FULL) &&(south.getValue(FACING) == Direction.EAST &&
                        (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 3 || south.getValue(SHAPE) == 4) ||
                        south.getValue(FACING) == Direction.SOUTH && (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 2))) &&
                (north.getBlock() instanceof VerticalSlabBase && !north.getValue(FULL) && (north.getValue(FACING) == Direction.EAST &&
                        (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 2 || north.getValue(SHAPE) == 3)||
                        north.getValue(FACING) == Direction.NORTH && (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 2))))
        ) {
            if (east.getBlock() instanceof VerticalSlabBase && !east.getValue(FULL)) {
                if (east.getValue(FACING) == Direction.NORTH) {
                    if (south.getBlock() instanceof VerticalSlabBase && (
                        (south.getValue(FACING) == Direction.EAST && (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 2 || south.getValue(SHAPE) == 3 || south.getValue(SHAPE) == 4)) ||
                        (south.getValue(FACING) == Direction.SOUTH && (south.getValue(SHAPE) == 0 || south.getValue(SHAPE) == 2))
                    )){
                        if (west.getBlock() instanceof VerticalSlabBase && !west.getValue(FULL)) {
                            if (west.getValue(FACING) == Direction.NORTH) return center.setValue(SHAPE, 1);
                            else if (west.getValue(FACING) == Direction.SOUTH) return center.setValue(SHAPE, 2);
                        }
                        return center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 3);
                }
                if (east.getValue(FACING) == Direction.SOUTH) {
                    if (north.getBlock() instanceof VerticalSlabBase && (
                        (north.getValue(FACING) == Direction.EAST && (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 1 || north.getValue(SHAPE) == 4 || north.getValue(SHAPE) == 3)) ||
                        (north.getValue(FACING) == Direction.NORTH && (north.getValue(SHAPE) == 0 || north.getValue(SHAPE) == 2))
                    )){
                        if (west.getBlock() instanceof VerticalSlabBase && !west.getValue(FULL)) {
                            if (west.getValue(FACING) == Direction.NORTH) return center.setValue(SHAPE, 1);
                            else if (west.getValue(FACING) == Direction.SOUTH) return center.setValue(SHAPE, 2);
                        }
                        return center.setValue(SHAPE, 0);
                    }
                    return center.setValue(SHAPE, 4);
                }
            }
            if (west.getBlock() instanceof VerticalSlabBase && !west.getValue(FULL)) {
                if (west.getValue(FACING) == Direction.NORTH) return center.setValue(SHAPE, 1);
                else if (west.getValue(FACING) == Direction.SOUTH) return center.setValue(SHAPE, 2);
            }
        }
        return center.setValue(SHAPE, 0);
    }
}
