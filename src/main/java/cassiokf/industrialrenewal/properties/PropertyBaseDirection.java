package cassiokf.industrialrenewal.properties;

import cassiokf.industrialrenewal.util.enums.enumproperty.EnumBaseDirection;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.minecraft.block.properties.PropertyEnum;

import java.util.Collection;
import java.util.function.Predicate;

public class PropertyBaseDirection extends PropertyEnum<EnumBaseDirection>
{
    protected PropertyBaseDirection(String name, Collection<EnumBaseDirection> allowedValues)
    {
        super(name, EnumBaseDirection.class, allowedValues);
    }

    /**
     * Create a new PropertyDirection with the given name
     * @param name
     * @return 
     */
    public static PropertyBaseDirection create(String name)
    {
        return create(name, enumBaseDirection -> true);
    }

    /**
     * Create a new PropertyDirection with all directions that match the given Predicate
     * @param name
     * @param filter
     * @return 
     */
    public static PropertyBaseDirection create(String name, Predicate<EnumBaseDirection> filter)
    {
        return create(name, Collections2.filter(Lists.newArrayList(EnumBaseDirection.values()), filter::test));
    }

    /**
     * Create a new PropertyDirection for the given direction values
     * @param name
     * @param values
     * @return 
     */
    public static PropertyBaseDirection create(String name, Collection<EnumBaseDirection> values)
    {
        return new PropertyBaseDirection(name, values);
    }
}
