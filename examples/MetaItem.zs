#loader GregTech
import mods.devtech.MetaItem;
import mods.devtech.ItemComponent;
import mods.devtech.OrePrefix;
import mods.devtech.MaterialPredicate;
import mods.devtech.MaterialIconType;

var geode = OrePrefix.create("geode", "geode", 0, MaterialPredicate.isDust & MaterialPredicate.hasFlag("GENERATE_ORE"));

var metaItem = MetaItem.build("test", geode);

metaItem.create(1, "devtech.battery.lv").addComponents(ItemComponent.electricStats(1, 1234567890));
metaItem.create(2, "devtech.food").addComponents(ItemComponent.foodStats(3, 1));
metaItem.create(3, "devtech.vial").addComponents(ItemComponent.fluidStats(16));