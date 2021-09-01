package com.blackout.nofallingblocks.registry;

import biomesoplenty.common.util.inventory.ItemGroupBOP;
import biomesoplenty.core.BiomesOPlenty;
import com.blackout.extendedslabs.ExtendedSlabs;
import com.blackout.extendedslabs.blocks.VerticalSlabBlock;
import com.blackout.extendedslabs.blocks.falling.FallingSlabBlock;
import com.blackout.extendedslabs.blocks.falling.FallingVerticalSlabBlock;
import com.blackout.nofallingblocks.NoFallingBlocks;
import com.blackout.nofallingblocks.blocks.NFBAnvilBlock;
import com.blackout.nofallingblocks.blocks.NFBConcretePowderBlock;
import com.blackout.nofallingblocks.blocks.NFBDragonEggBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = NoFallingBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NFBBlocks {
    public static final DeferredRegister<Block> MINECRAFT_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    public static final DeferredRegister<Item> MINECRAFT_ITEM_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    public static final RegistryObject<Block> SAND = registerMinecraftBlock("sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.SAND).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> RED_SAND = registerMinecraftBlock("red_sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> GRAVEL = registerMinecraftBlock("gravel", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.STONE).strength(0.6F).sound(SoundType.GRAVEL)), ItemGroup.TAB_BUILDING_BLOCKS, true);

    public static final RegistryObject<Block> DRAGON_EGG = registerMinecraftBlock("dragon_egg", () -> new NFBDragonEggBlock(AbstractBlock.Properties.of(Material.EGG, MaterialColor.COLOR_BLACK).strength(3.0F, 9.0F).lightLevel((state) -> { return 1; }).noOcclusion()), ItemGroup.TAB_BUILDING_BLOCKS, true);

    public static final RegistryObject<Block> ANVIL = registerMinecraftBlock("anvil", () -> new NFBAnvilBlock(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> CHIPPED_ANVIL = registerMinecraftBlock("chipped_anvil", () -> new NFBAnvilBlock(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> DAMAGED_ANVIL = registerMinecraftBlock("damaged_anvil", () -> new NFBAnvilBlock(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL)), ItemGroup.TAB_BUILDING_BLOCKS, true);

    public static final RegistryObject<Block> WHITE_CONCRETE_POWDER = registerMinecraftBlock("white_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.WHITE_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.WHITE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> ORANGE_CONCRETE_POWDER = registerMinecraftBlock("orange_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.ORANGE_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.ORANGE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_POWDER = registerMinecraftBlock("magenta_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.MAGENTA_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.MAGENTA).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_POWDER = registerMinecraftBlock("light_blue_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.LIGHT_BLUE_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.LIGHT_BLUE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> YELLOW_CONCRETE_POWDER = registerMinecraftBlock("yellow_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.YELLOW_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.YELLOW).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> LIME_CONCRETE_POWDER = registerMinecraftBlock("lime_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.LIME_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.LIME).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> PINK_CONCRETE_POWDER = registerMinecraftBlock("pink_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.PINK_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.PINK).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> GRAY_CONCRETE_POWDER = registerMinecraftBlock("gray_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.GRAY_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.GRAY).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_POWDER = registerMinecraftBlock("light_gray_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.LIGHT_GRAY_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.LIGHT_GRAY).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> CYAN_CONCRETE_POWDER = registerMinecraftBlock("cyan_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.CYAN_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.CYAN).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> PURPLE_CONCRETE_POWDER = registerMinecraftBlock("purple_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.PURPLE_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.PURPLE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> BLUE_CONCRETE_POWDER = registerMinecraftBlock("blue_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.BLUE_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.BLUE).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> BROWN_CONCRETE_POWDER = registerMinecraftBlock("brown_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.BROWN_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.BROWN).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> GREEN_CONCRETE_POWDER = registerMinecraftBlock("green_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.GREEN_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.GREEN).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> RED_CONCRETE_POWDER = registerMinecraftBlock("red_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.RED_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.RED).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);
    public static final RegistryObject<Block> BLACK_CONCRETE_POWDER = registerMinecraftBlock("black_concrete_powder", () -> new NFBConcretePowderBlock(Blocks.BLACK_CONCRETE, AbstractBlock.Properties.of(Material.SAND, DyeColor.BLACK).strength(0.5F).sound(SoundType.SAND)), ItemGroup.TAB_BUILDING_BLOCKS, true);

    public static <B extends Block> RegistryObject<B> registerMinecraftBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
        RegistryObject<B> block = NFBBlocks.MINECRAFT_BLOCK_OVERRIDES.register(name, supplier);
        if (generateItem)MINECRAFT_ITEM_BLOCK_OVERRIDES.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    public static final DeferredRegister<Block> BOP_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "biomesoplenty");
    public static final DeferredRegister<Item> BOP_ITEM_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.ITEMS, "biomesoplenty");

    public static final RegistryObject<Block> BOP_WHITE_SAND = registerBOPBlock("white_sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.QUARTZ).strength(0.5F).sound(SoundType.SAND)), ItemGroupBOP.instance, true);
    public static final RegistryObject<Block> BOP_ORANGE_SAND = registerBOPBlock("orange_sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.SAND)), ItemGroupBOP.instance, true);
    public static final RegistryObject<Block> BOP_BLACK_SAND = registerBOPBlock("black_sand", () -> new Block(AbstractBlock.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).strength(0.5F).sound(SoundType.SAND)), ItemGroupBOP.instance, true);

    public static <B extends Block> RegistryObject<B> registerBOPBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
        RegistryObject<B> block = NFBBlocks.BOP_BLOCK_OVERRIDES.register(name, supplier);
        if (generateItem)BOP_ITEM_BLOCK_OVERRIDES.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }

    public static final DeferredRegister<Block> ESP_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "extendedslabs");
    public static final DeferredRegister<Item> ESP_ITEM_BLOCK_OVERRIDES = DeferredRegister.create(ForgeRegistries.ITEMS, "extendedslabs");

    public static final RegistryObject<Block> SAND_SLAB = registerESPBlock("sand_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.SAND)), ExtendedSlabs.GROUP, true);
    public static final RegistryObject<Block> RED_SAND_SLAB = registerESPBlock("red_sand_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.RED_SAND)), ExtendedSlabs.GROUP, true);
    public static final RegistryObject<Block> GRAVEL_SLAB = registerESPBlock("gravel_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.GRAVEL)), ExtendedSlabs.GROUP, true);
    public static final RegistryObject<Block> SAND_VERTICAL = registerESPBlock("vertical_sand_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.copy(Blocks.SAND)), ExtendedSlabs.GROUP, true);
    public static final RegistryObject<Block> RED_SAND_VERTICAL = registerESPBlock("vertical_red_sand_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.copy(Blocks.RED_SAND)), ExtendedSlabs.GROUP, true);
    public static final RegistryObject<Block> GRAVEL_VERTICAL = registerESPBlock("vertical_gravel_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.copy(Blocks.GRAVEL)), ExtendedSlabs.GROUP, true);

    public static <B extends Block> RegistryObject<B> registerESPBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
        RegistryObject<B> block = NFBBlocks.ESP_BLOCK_OVERRIDES.register(name, supplier);
        if (generateItem)ESP_ITEM_BLOCK_OVERRIDES.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }
}
