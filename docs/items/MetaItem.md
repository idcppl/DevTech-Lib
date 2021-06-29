# MetaItem
This is used to make new items with GregTech Community Edition MetaItem system.

## import
`import mods.devtech.MetaItem;`

## .build(name, orePrefixes)
> This will be the foundation that you build upon to add items. There can be a maximum of 32 OrePrefixes.
>
> **Type:** Method
> **Returns:** MetaItem
> | Parameters  | types         |
> |-------------|---------------|
> | name        | string        |
> | orePrefixes | OrePrefix...  |

## .create(id, name)
> This will add an item to the builder.
>
> **Type:** Method
> **Returns:** MetaItem
> | Parameters  | types     |
> |-------------|-----------|
> | id          | int       |
> | name        | string    |

## .addComponents(components)
> This will add stats to the item. I.E. food stats, electric stats, and fluid stats.
>
> **Type:** Method
> **Returns:** MetaItem
> | Parameters  | types             |
> |-------------|-------------------|
> | components  | ItemCompoenent... |

## .oreDict(name)
> This will add the item to an oreDict.
>
> **Type:** Method
> **Returns:** MetaItem
> | Parameters  | types     |
> |-------------|-----------|
> | name        | string    |

## .invisible()
> This will hide the item from JEI.
>
> **Type:** Method
> **Returns:** MetaItem

## .stackSize(size)
> This will make the item a certain stack size.
>
> **Type:** Method
> **Returns:** MetaItem
> | Parameters  | types     |
> |-------------|-----------|
> | size        | int       |

## .burnTime(time)
> This will make the item a burnable fuel.
>
> **Type:** Method
> **Returns:** MetaItem
> | Parameters  | types     |
> |-------------|-----------|
> | time        | int       |