package lu.kolja.expandedae.datagen;

import lu.kolja.expandedae.definition.ExpItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ExpModelProvider extends ItemModelProvider {
    public ExpModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var item : ExpItems.getItems()) {

        }
    }
    /* TODO FIX
    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(BuiltInRegistries.ITEM.getKey(item).getPath(), new ResourceLocation("", ""))
    }
    */
}
