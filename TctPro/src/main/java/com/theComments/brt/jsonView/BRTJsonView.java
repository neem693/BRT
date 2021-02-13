package com.theComments.brt.jsonView;

public class BRTJsonView {
	
	public static interface Works extends WorksCommon{};
	public static interface WorksCommon extends CreateArtist, ArtistCommon,FileSaveCommon,Type2Common{};
	
	public static interface Create extends CreateArtist,CreateWorks,CreateCommon{};
	public static interface CreateArtist extends CreateCommon {};
	public static interface CreateWorks extends CreateCommon{};
	public static interface CreateCommon {};

	public static interface Artist {};
	public static interface ArtistCommon {};
	
	public static interface FileSave {};
	public static interface FileSaveCommon {};
	
	public static interface Type2 {};
	public static interface Type2Common extends Type1Common {};
	
	public static interface Type1 {};
	public static interface Type1Common {};
	
}
