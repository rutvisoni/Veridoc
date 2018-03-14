package mypackage;

import org.apache.poi.hssf.util.CellRangeAddress;

public class CellRangeAddressWrapper {
	public CellRangeAddress range;

    /**
     * @param newMergedRegion the CellRangeAddress object to wrap.
     */
    public CellRangeAddressWrapper(org.apache.poi.ss.util.CellRangeAddress newMergedRegion)
    {
        this.range = (CellRangeAddress) newMergedRegion;
    }

    /**
     * @param o the object to compare.
     * @return -1 the current instance is prior to the object in parameter, 0: equal, 1: after...
     */
    public int compareTo(CellRangeAddressWrapper o)
    {

        if (range.getFirstColumn() < o.range.getFirstColumn() && range.getFirstRow() < o.range.getFirstRow())
        {
            return -1;
        }
        else if (range.getFirstColumn() == o.range.getFirstColumn() && range.getFirstRow() == o.range.getFirstRow())
        {
            return 0;
        }
        else
        {
            return 1;
        }

    }
}
