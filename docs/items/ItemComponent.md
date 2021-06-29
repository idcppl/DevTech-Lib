# ItemComponent
This is used to add stats to MetaItem's.

## import 
`import mods.devtech.ItemComponent;`

## .foodStats(foodLevel, saturation, isDrink)
> This will make the item a food item with the option for it to use the drinking action. Saturation is calculated like, `foodLevel * saturation * 2`.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters  | types     |
> |-------------|-----------|
> | foodLevel   | int       |
> | saturation  | float     |
> | isDrink     | bool      |

## .foodStats(foodLevel, saturation)
> This will make the item a food item. Saturation is calculated like, `foodLevel * saturation * 2`.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters  | types     |
> |-------------|-----------|
> | foodLevel   | int       |
> | saturation  | float     |

## .electricStats(maxCharge, tier)
> This will make the item a battery that is dischargeable and rechargeable.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters  | types     |
> |-------------|-----------|
> | maxCharge   | long      |
> | tier        | int       |

## .electricStats(maxCharge, tier, rechargeable)
> This will make the item a battery that is dischargeable and with the option of it being rechargeable.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters  | types     |
> |-------------|-----------|
> | maxCharge   | long      |
> | tier        | int       |
> | rechargeable| bool      |


## .electricStats(maxCharge, tier, rechargeable, dischargeable)
> This will make the item a battery with the option of it being dischargeable and/or rechargeable.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters      | types     |
> |-----------------|-----------|
> | maxCharge       | long      |
> | tier            | int       |
> | rechargeable    | bool      |
> | dischargeable   | bool      |

## .fluidStats(maxCapacity, minFluidTemperature, maxFluidTemperature, allowPartlyFill)
> This will make the item a fluid container with the choice of temperature range and if it can be partly filled.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters          | types     |
> |---------------------|-----------|
> | maxCapacity         | int       |
> | minFluidTemperature | int       |
> | maxFluidTemperature | int       |
> | allowPartlyFill     | bool      |

## .fluidStats(maxCapacity, allowPartlyFill)
> This will make the item a fluid container with the temperature being Integer.MIN_VALUE to Integer.MAX_VALUE and if it can be partly filled.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters          | types     |
> |---------------------|-----------|
> | maxCapacity         | int       |
> | allowPartlyFill     | bool      |

## .fluidStats(maxCapacity)
> This will make the item a fluid container with the temperature being Integer.MIN_VALUE to Integer.MAX_VALUE and can't be partly filled.
>
> **Type:** Method
> **Returns:** ItemComponent
> | Parameters          | types     |
> |---------------------|-----------|
> | maxCapacity         | int       |
