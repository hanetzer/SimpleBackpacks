package org.sweetiebelle.ironbackpacks.common.item;

import org.sweetiebelle.ironbackpacks.common.BackpackType;

public class ItemLeatherBackpack extends ItemBackpack {

    public ItemLeatherBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.LEATHER;
    }

}
