# Machine
This is used to create custom machines, tanks, chests, ect.

## import
`import mods.devtech.Machine;`

## .createSimpleMachine(id, nameID, recipeMap, renderer, tier)
> This will add a machine that is like a furnace, assembler, chemical reactor, ect.
>
> **Type:** Method
> **Returns:** void
> | Parameters  | types             |
> |-------------|-------------------|
> | id          | int               |
> | nameID      | string            |
> | recipeMap   | RecipeMap         |
> | renderer    | OverlayRenderer   |
> | tier        | int               |

## .createSimpleGenerator(id, nameID, fuelRecipeMap, renderer, tier)
> This will add a machine that is like a steam turbine, gas turbine, diesel generator, ect.
>
> **Type:** Method
> **Returns:** void
> | Parameters      | types             |
> |-----------------|-------------------|
> | id              | int               |
> | nameID          | string            |
> | fuelRecipeMap   | FuelRecipeMap     |
> | renderer        | OverlayRenderer   |
> | tier            | int               |

## .createMacerator(id, nameID, recipeMap, renderer, tier, outputAmount)
> This will add a machine that is like a macerator, with different amounts of output slots.
>
> **Type:** Method
> **Returns:** void
> | Parameters      | types             |
> |-----------------|-------------------|
> | id              | int               |
> | nameID          | string            |
> | fuelRecipeMap   | FuelRecipeMap     |
> | renderer        | OverlayRenderer   |
> | tier            | int               |

## .createChest(id, nameID, material, rowSize, amountRows)
> This will add a chest.
>
> **Type:** Method
> **Returns:** void
> | Parameters      | types             |
> |-----------------|-------------------|
> | id              | int               |
> | nameID          | string            |
> | material        | SolidMaterial     |
> | rowSize         | int               |
> | amountRows      | int               |

## .createTank(id, nameID, material, tankSize, maxSizeVertical, maxSizeHorizontal)
> This will add a tank and allows you to set the size of the multiblock.
>
> **Type:** Method
> **Returns:** void
> | Parameters          | types             |
> |---------------------|-------------------|
> | id                  | int               |
> | nameID              | string            |
> | material            | SolidMaterial     |
> | tankSize            | int               |
> | maxSizeVertical     | int               |
> | maxSizeHorizontal   | int               |

## .createQuantumChest(id, nameID, tier, storage)
> This will add a quantum chest with the set amount of storage.
>
> **Type:** Method
> **Returns:** void
> | Parameters          | types             |
> |---------------------|-------------------|
> | id                  | int               |
> | nameID              | string            |
> | tier                | int               |
> | storage             | long              |

## .createQuantumTank(id, nameID, tier, storage)
> This will add a quantum tank with the set amount of storage.
>
> **Type:** Method
> **Returns:** void
> | Parameters          | types             |
> |---------------------|-------------------|
> | id                  | int               |
> | nameID              | string            |
> | tier                | int               |
> | storage             | int               |