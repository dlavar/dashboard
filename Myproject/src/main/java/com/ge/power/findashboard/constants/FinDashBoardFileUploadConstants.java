package com.ge.power.findashboard.constants;

public interface FinDashBoardFileUploadConstants {
	
	String SEGMENT_NOT_IN_GIVEN_VALUES= "Segment value should be any " +
			"one of this lis (PWAELM,SAATUR,PGSTOT,TOTWDP,TOTWTR,DISPOW,NAAGEN,SPEGELM,SCMCOE,PWATGC,PWATCO,PWATSV,PWATHQ,ALOSEF,ALSTHQ,SEPADJ,PWALLM)";
	String validSegmentValues[] = {"PWAELM","SAATUR","PGSTOT","TOTWDP","TOTWTR","DISPOW","NAAGEN","SPEGELM","SCMCOE","PWATGC","PWATCO","PWATSV","PWATHQ","ALOSEF","ALSTHQ","SEPADJ","PWALLM"};
	String segmentCellIndex = "2";
	String EXTOGEOIINDEX ="16";
	String validEXTGEOOIValues[] = {"EXT","OGE","OI"};
	String EXTOGEOINOTINGIVENVALUES="Value should be in (EXT,OGE,OI)";
	String EQUIValues[]={"Equip","Serv"};
	String EQUIPValuesNotValid = "Value should be in either Equip or Serv";
	String EquipIndex = "4";
	String SALESOIINDEX="3";
	String MarginIndex="14";
	String SalesMarginError="either Sale/OI should Sale, or if (Sale/OI is OI then Margin Should be 0";
	String SALES="Sales";
	String OI ="OI";
	String CountryStateIndex="9";
	String countryNotinlistError = "Country US State is not Matched to Given List";
}
