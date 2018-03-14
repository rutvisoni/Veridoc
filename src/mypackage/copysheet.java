package mypackage;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

@SuppressWarnings("deprecation")

public class copysheet {
	public static Workbook mergeExcelFiles(Workbook book, List<InputStream> inList)
    {
        try
        {
            for (InputStream fin : inList)	
            {
                Workbook b = (Workbook) WorkbookFactory.create(fin);
                for (int i = 0; i < b.getNumberOfSheets(); i++)
                {
                    // not entering sheet name, because of duplicated names
                    copySheets(((org.apache.poi.ss.usermodel.Workbook) book).createSheet(((org.apache.poi.ss.usermodel.Workbook) b).getSheetName(i)), ((org.apache.poi.ss.usermodel.Workbook) b).getSheetAt(i));
                }
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }

        return (Workbook) book;
    }

	private static void copySheets(org.apache.poi.ss.usermodel.Sheet sheet, org.apache.poi.ss.usermodel.Sheet sheet2) {
		// TODO Auto-generated method stub
		
		copySheets(sheet, sheet2);
	}

	private static void copySheets(Sheet createSheet, Sheet sheetAt, boolean b) {
		// TODO Auto-generated method stub
		
		int maxColumnNum = 0;
        Map<Integer, CellStyle> styleMap = (b) ? new HashMap<Integer, CellStyle>() : null;
        for (int i = ((org.apache.poi.ss.usermodel.Sheet) sheetAt).getFirstRowNum(); i <= ((org.apache.poi.ss.usermodel.Sheet) sheetAt).getLastRowNum(); i++)
        {
            Row srcRow =  ((org.apache.poi.ss.usermodel.Sheet) sheetAt).getRow(i);
            Row destRow = (Row) ((org.apache.poi.ss.usermodel.Sheet) createSheet).createRow(i);
            if (srcRow != null)
            {
                copyRow(sheetAt, createSheet, srcRow, destRow, styleMap);
                if (((org.apache.poi.ss.usermodel.Row) srcRow).getLastCellNum() > maxColumnNum)
                {
                    maxColumnNum = ((org.apache.poi.ss.usermodel.Row) srcRow).getLastCellNum();
                }
            }
        }
        for (int i = 0; i <= maxColumnNum; i++)
        {
           ((org.apache.poi.ss.usermodel.Sheet) createSheet).setColumnWidth(i, ((org.apache.poi.ss.usermodel.Sheet) sheetAt).getColumnWidth(i));
        }
		
	}

	private static void copyRow(Sheet sheetAt, Sheet createSheet, Row srcRow,
			Row destRow, Map<Integer, CellStyle> styleMap) {
		// TODO Auto-generated method stub
		
		// manage a list of merged zone in order to not insert two times a merged zone  
        Set<CellRangeAddressWrapper> mergedRegions = new TreeSet<CellRangeAddressWrapper>();
        ((org.apache.poi.ss.usermodel.Row) destRow).setHeight(((org.apache.poi.ss.usermodel.Row) srcRow).getHeight());
        // reckoning delta rows  
        int deltaRows = ((org.apache.poi.ss.usermodel.Row) destRow).getRowNum() - ((org.apache.poi.ss.usermodel.Row) srcRow).getRowNum();
        // pour chaque row  
        for (int j = ((org.apache.poi.ss.usermodel.Row) srcRow).getFirstCellNum(); j <= ((org.apache.poi.ss.usermodel.Row) srcRow).getLastCellNum(); j++)
        {
            Cell oldCell = (Cell) ((org.apache.poi.ss.usermodel.Row) srcRow).getCell(j); // ancienne cell  
            Cell newCell = (Cell) ((org.apache.poi.ss.usermodel.Row) destRow).getCell(j); // new cell   
            if (oldCell != null)
            {
                if (newCell == null)
                {
                    newCell = (Cell) ((org.apache.poi.ss.usermodel.Row) destRow).createCell(j);
                }
                // copy chaque cell  
                copyCell(oldCell, newCell, styleMap);
                // copy les informations de fusion entre les cellules  
                //System.out.println("row num: " + srcRow.getRowNum() + " , col: " + (short)oldCell.getColumnIndex());  
                CellRangeAddress mergedRegion = getMergedRegion(sheetAt, ((org.apache.poi.ss.usermodel.Row) srcRow).getRowNum(), (short) ((org.apache.poi.ss.usermodel.Cell) oldCell).getColumnIndex());

                if (mergedRegion != null)
                {
                    //System.out.println("Selected merged region: " + mergedRegion.toString());  
                    CellRangeAddress newMergedRegion = new CellRangeAddress(mergedRegion.getFirstRow() + deltaRows, mergedRegion.getLastRow() + deltaRows, mergedRegion.getFirstColumn(), mergedRegion.getLastColumn());
                    //System.out.println("New merged region: " + newMergedRegion.toString());  
                    CellRangeAddressWrapper wrapper = new CellRangeAddressWrapper(newMergedRegion);
                    if (isNewMergedRegion(wrapper, mergedRegions))
                    {
                        mergedRegions.add(wrapper);
                       ((org.apache.poi.ss.usermodel.Sheet) createSheet).addMergedRegion(wrapper.range);
                    }
                }
            }
        }
		
		
		
	}

	private static boolean isNewMergedRegion(CellRangeAddressWrapper wrapper,
			Set<CellRangeAddressWrapper> mergedRegions) {
		// TODO Auto-generated method stub
		return !mergedRegions.contains(wrapper);
	}

	private static CellRangeAddress getMergedRegion(Sheet sheetAt, int rowNum,
			short columnIndex) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < ((org.apache.poi.ss.usermodel.Sheet) sheetAt).getNumMergedRegions(); i++)
        {
            CellRangeAddress merged = (CellRangeAddress) ((org.apache.poi.ss.usermodel.Sheet) sheetAt).getMergedRegion(i);
            if (merged.isInRange(rowNum, columnIndex))
            {
                return merged;
            }
        }
		return null;
	}

	private static void copyCell(Cell oldCell, Cell newCell,
			Map<Integer, CellStyle> styleMap) {
		// TODO Auto-generated method stub
		
		if (styleMap != null)
        {
            if (((org.apache.poi.ss.usermodel.Row) oldCell).getSheet().getWorkbook() == ((org.apache.poi.ss.usermodel.Row) newCell).getSheet().getWorkbook())
            {
                ((org.apache.poi.ss.usermodel.Cell) newCell).setCellStyle(((org.apache.poi.ss.usermodel.Cell) oldCell).getCellStyle());
            }
            else
            {
                int stHashCode = ((org.apache.poi.ss.usermodel.Cell) oldCell).getCellStyle().hashCode();
                CellStyle newCellStyle = styleMap.get(stHashCode);
                if (newCellStyle == null)
                {
                    newCellStyle = ((org.apache.poi.ss.usermodel.Row) newCell).getSheet().getWorkbook().createCellStyle();
                    newCellStyle.cloneStyleFrom(((org.apache.poi.ss.usermodel.Cell) oldCell).getCellStyle());
                    styleMap.put(stHashCode, newCellStyle);
                }
                ((org.apache.poi.ss.usermodel.Cell) newCell).setCellStyle(newCellStyle);
            }
        }
        switch (((org.apache.poi.ss.usermodel.Cell) oldCell).getCellType())
        {
            case Cell.CELL_TYPE_STRING:
                ((HSSFCell) newCell).setCellValue(((HSSFCell) oldCell).getStringCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                ((HSSFCell) newCell).setCellValue(((HSSFCell) oldCell).getNumericCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                ((HSSFCell) newCell).setCellType(HSSFCell.CELL_TYPE_BLANK);
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                ((HSSFCell) newCell).setCellValue(((org.apache.poi.ss.usermodel.Cell) oldCell).getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                ((HSSFCell) newCell).setCellErrorValue(((org.apache.poi.ss.usermodel.Cell) oldCell).getErrorCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                ((HSSFCell) newCell).setCellFormula(((org.apache.poi.ss.usermodel.Cell) oldCell).getCellFormula());
                break;
            default:
                break;
        }
		
	}



}
