Attribute VB_Name = "SWimApi"
Public Declare Function SWimApiOpen Lib "wcl_dll" (IdInstance As Long, ByVal TypeClient As Long, _
                                                   ByVal ModeEvent As Long, ByVal ModeInterface As Long, _
                                                   ByVal Ldebug As Long, ByVal FileTrace As String, _
                                                   ByVal ModuloTrace As Long, ByVal IdStation As Long, _
                                                   ByVal CodeLang As Long, ByVal Path As String, _
                                                   ByVal ModeEcho As Long, ByVal TimeOutMaxMessage As Long, _
                                                   ByVal ModeOffLine As Long, ByVal PathServeur As String, _
                                                   ByVal Scellement As Long, ByVal PathMemoireDouble As String, _
                                                   ByVal NbJoursSauves As Long) As Long
                                                    
Public Declare Function SWimApiClose Lib "wcl_dll" (ByVal IdInstance As Integer, ByVal StopServeur As Integer) As Long
Public Declare Function SWimApiSendMessage Lib "wcl_dll" (ByVal IdInstance As Long, ByVal IdService As String, ByVal LPZBuffer As Long, ByRef LgBuf As Long) As Long
Public Declare Function SWimApiGetMessage Lib "wcl_dll" (ByVal IdInstance As Long, ByVal IdService As String, ByVal LPZBuffer As Long, ByRef LgBuf As Long) As Long
Public Declare Function ATAG_WriteInit Lib "wcl_dll" (ByVal BufferToBuild As Long, ByVal MaxLengthToBuild As Integer) As Long
Public Declare Function ATAG_ReadInit Lib "wcl_dll" (ByVal BufferReceived As Long, ByVal MaxLengthReceived As Integer) As Long
Public Declare Function ATAG_SetStringVal Lib "wcl_dll" (ByVal TagToAdd As String, ByVal ASCIIValueToAdd As String) As Long
Public Declare Function ATAG_GetStringVal Lib "wcl_dll" (ByVal TagToExtract As String, ByVal ExtractedASCIIValue As String, ByVal SearchFromStart As Long) As Long

Public Declare Function SWimApiWaitSynchro Lib "wcl_dll" (ByVal IdInstance As Long, ByVal Time As Long) As Long



