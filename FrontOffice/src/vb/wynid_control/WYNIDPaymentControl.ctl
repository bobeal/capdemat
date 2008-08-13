VERSION 5.00
Begin VB.UserControl WYNIDPaymentControl 
   BackColor       =   &H00FFE2D1&
   ClientHeight    =   1590
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   5235
   ScaleHeight     =   1543.69
   ScaleMode       =   0  'User
   ScaleWidth      =   5235
   Begin VB.Label Cancel 
      BackColor       =   &H00FFE2D1&
      BackStyle       =   0  'Transparent
      Height          =   1335
      Left            =   3480
      TabIndex        =   3
      Top             =   120
      Width           =   1575
   End
   Begin VB.Line Line4 
      BorderColor     =   &H00C0C0C0&
      X1              =   5040
      X2              =   5040
      Y1              =   116.505
      Y2              =   1398.059
   End
   Begin VB.Line Line3 
      BorderColor     =   &H00C0C0C0&
      X1              =   3480
      X2              =   5040
      Y1              =   1398.059
      Y2              =   1398.059
   End
   Begin VB.Line Line2 
      BorderColor     =   &H00C0C0C0&
      X1              =   5040
      X2              =   3480
      Y1              =   116.505
      Y2              =   116.505
   End
   Begin VB.Line Line1 
      BorderColor     =   &H00C0C0C0&
      X1              =   3480
      X2              =   3480
      Y1              =   116.505
      Y2              =   1398.059
   End
   Begin VB.Image Button 
      Height          =   315
      Left            =   3600
      Picture         =   "WYNIDPaymentControl.ctx":0000
      Top             =   600
      Width           =   330
   End
   Begin VB.Label CancelLabel 
      Alignment       =   2  'Center
      BackStyle       =   0  'Transparent
      Caption         =   "Annuler"
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   11.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00C1614D&
      Height          =   255
      Left            =   3960
      TabIndex        =   1
      Top             =   615
      Width           =   975
   End
   Begin VB.Label WYNIDLabel 
      Alignment       =   2  'Center
      BackColor       =   &H00FFFFFF&
      BorderStyle     =   1  'Fixed Single
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H80000017&
      Height          =   1335
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   3255
   End
   Begin VB.Label CancelButton 
      BackColor       =   &H00FFE2D1&
      Height          =   1335
      Left            =   3480
      TabIndex        =   2
      Top             =   120
      Width           =   1575
   End
End
Attribute VB_Name = "WYNIDPaymentControl"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = True
Option Explicit

Dim montant As String
Dim caisse As String
Dim transaction As String
Dim wynidPath As String
Dim wynidLog As String

Dim instanceId As Long
Dim buffer_request As String
Dim longueur_request As Long
Dim ptr_request As Long

Dim buffer_response As String
Dim longueur_response As Long
Dim ptr_response As Long

Dim canCancel As Boolean
Dim cancelled As Boolean

Dim foreground As Long
Dim background As Long
Dim disabledColor As Long

Dim serviceCode As String

Dim printerName As String

Private Sub Cancel_Click()

    If canCancel Then
        cancelled = True
        Call disableCancel
    End If

End Sub

Private Sub CancelButton_MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)
    
    ' Change la couleur du bouton (mode pressé)
    If canCancel Then
        CancelButton.BackColor = background
        CancelLabel.ForeColor = foreground
    End If

End Sub

Private Sub CancelButton_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)

    ' Change la couleur du bouton (mode relaché)
    If canCancel Then
        CancelButton.BackColor = foreground
        CancelLabel.ForeColor = background
    End If

End Sub

Private Sub UserControl_Initialize()

    WYNIDLabel.Caption = Chr(13) & "INITIALISATION DU" & Chr(13) & "PAIEMENT"
    
    ' Initialisation des variables
    buffer_request = String(20000, " ")
    longueur_request = Len(buffer_request)
    ptr_request = StrPtr(buffer_request)
    buffer_response = String(20000, " ")
    longueur_response = Len(buffer_response)
    ptr_response = StrPtr(buffer_response)
    serviceCode = String(4, " ")
    canCancel = True
    cancelled = False

End Sub

Private Sub UserControl_ReadProperties(PropBag As PropertyBag)

    ' Lit les propriétés du HTML
    montant = PropBag.ReadProperty("montant")
    caisse = PropBag.ReadProperty("caisse")
    transaction = PropBag.ReadProperty("transaction")
    wynidPath = PropBag.ReadProperty("wynidPath")
    wynidLog = PropBag.ReadProperty("wynidLog")
    foreground = Val(PropBag.ReadProperty("foreground"))
    background = Val(PropBag.ReadProperty("background"))
    disabledColor = Val(PropBag.ReadProperty("disabledColor"))
    printerName = PropBag.ReadProperty("printer")
    UserControl.BackColor = background
    CancelButton.BackColor = background
    CancelLabel.ForeColor = foreground
    WYNIDLabel.ForeColor = foreground
  
    Dim X As Printer
    For Each X In Printers
        If X.DeviceName = printerName Then
            ' Définit l'imprimante comme imprimante par
            ' défaut du système.
            Set Printer = X
            ' Cesse la recherche d'imprimante.
            Exit For
        End If
    Next

End Sub

Public Sub disableCancel()

    ' desactive le bouton 'annuler'
    CancelButton.Enabled = False
    CancelButton.BackColor = disabledColor
    CancelLabel.ForeColor = "&H00C0C0C0"

End Sub

Public Function doPayment()

    ' Ouverture du client WYNID
    If SWimApiOpen(instanceId, 1, 1, 0, 1, wynidLog, 2000, caisse, 250, wynidPath, 3, 20, 0, "", 0, "", 0) = 0 Then
        
        ' Opération de maintenance
        If ATAG_WriteInit(ptr_request, longueur_request) = 1 Then
            If ATAG_SetStringVal("SV", "s2") = 1 And ATAG_SetStringVal("CD", "c1c") = 1 Then
                If SWimApiSendMessage(instanceId, "s2", ptr_request, longueur_request) = 0 Then
                
                    Do Until Left(serviceCode, 2) = "s2"
                        ' Attendre un message
                        Do While SWimApiWaitSynchro(instanceId, 100) = 7
                            DoEvents
                            
                            ' Annulation
                            If cancelled And canCancel Then
                            
                                canCancel = False
                            
                                If ATAG_WriteInit(ptr_request, longueur_request) = 1 Then
                                    If ATAG_SetStringVal("SV", "s3") = 1 And ATAG_SetStringVal("CD", "c0") = 1 Then
                                        If SWimApiSendMessage(instanceId, "s3", ptr_request, longueur_request) = 0 Then
                                            ' Demande d'annulation effectuée
                                        End If
                                    End If
                                Else
                                    MsgBox ("L'opération d'annulation a échouée (formatage de la requete)")
                                End If
                                                      
                            End If
                            
                        Loop
                        
                        If SWimApiGetMessage(instanceId, serviceCode, ptr_response, longueur_response) <> 0 Then
                            MsgBox ("Erreur lors de la reception du message")
                        End If
                    Loop
                    
                    longueur_response = Len(buffer_response)
                    ptr_response = StrPtr(buffer_response)
                            
                    If ATAG_ReadInit(ptr_response, longueur_response) = -1 Then
                        MsgBox ("Erreur lors de la lecture de la réponse")
                    End If
                    
                    If ATAG_GetStringVal("RS", buffer_request, 1) = -1 Then
                        MsgBox ("Erreur lors de la lecture de la réponse")
                    End If
                    
                    If Left(buffer_request, 2) <> "01" And Left(buffer_request, 2) <> "10" And Left(buffer_request, 2) <> "33" And Left(buffer_request, 2) <> "35" Then
                        MsgBox ("L'operation de maintenance a echouée " & buffer_request)
                    End If
                    
                Else
                    MsgBox ("L'opération de maintenance a échouée (impossible d'envoyer la requete)")
                End If
            Else
                MsgBox ("L'opération de maintenance a échouée (formatage de la requete)")
            End If
        Else
            MsgBox ("L'opération de maintenance a échouée")
        End If
        
        If Not cancelled Then
        
            ' Operation de débit
            If ATAG_WriteInit(ptr_request, longueur_request) = 1 Then
                If ATAG_SetStringVal("SV", "s0") = 1 And ATAG_SetStringVal("CD", "c1") = 1 And ATAG_SetStringVal("D10", montant) = 1 And ATAG_SetStringVal("D0", "978") = 1 Then
                    If SWimApiSendMessage(instanceId, "s0", ptr_request, longueur_request) = 0 Then
                    
                        ' Affichage des messages
                        Do Until Left(serviceCode, 2) = "s0"
        
                            ' Attendre un message
                            Do While SWimApiWaitSynchro(instanceId, 100) = 7
                                DoEvents
                                
                                ' Annulation
                                If cancelled And canCancel Then
                                
                                    canCancel = False
                                
                                    If ATAG_WriteInit(ptr_request, longueur_request) = 1 Then
                                        If ATAG_SetStringVal("SV", "s3") = 1 And ATAG_SetStringVal("CD", "c0") = 1 Then
                                            If SWimApiSendMessage(instanceId, "s3", ptr_request, longueur_request) = 0 Then
                                                ' Demande d'annulation effectuée
                                            End If
                                        End If
                                    Else
                                        MsgBox ("L'opération d'annulation a échouée (formatage de la requete)")
                                    End If
                                                                    
                                End If
                                
                            Loop
            
                            If SWimApiGetMessage(instanceId, serviceCode, ptr_response, longueur_response) <> 0 Then
                                MsgBox ("Erreur lors de la reception du message")
                            End If
                                                    
                            ' Message flash info
                            If Left(serviceCode, 3) = "s11" Then
                            
                                longueur_response = Len(buffer_response)
                                ptr_response = StrPtr(buffer_response)
                                
                                If ATAG_ReadInit(ptr_response, longueur_response) = -1 Then
                                    MsgBox ("Erreur lors de la lecture de la réponse flash info")
                                End If
                                
                                ' Type de message info
                                If ATAG_GetStringVal("D3G", buffer_request, 1) = 1 Then
                                    '
                                End If
                                                        
                            End If
                        
                            ' Message d'echo
                            If Left(serviceCode, 2) = "s5" Then
                            
                                longueur_response = Len(buffer_response)
                                ptr_response = StrPtr(buffer_response)
                                
                                If ATAG_ReadInit(ptr_response, longueur_response) = -1 Then
                                    MsgBox ("Erreur lors de la lecture de la réponse")
                                End If
                                
                                ' Echo du clavier
                                If ATAG_GetStringVal("D33", buffer_request, 1) = 1 Then
                                    ' rien
                                End If
                                
                                ' Echo de l'afficheur
                                If ATAG_GetStringVal("D34", buffer_request, 1) = 1 Then
                                    
                                    Dim counter As Long
                                    Dim counter2 As Long
                                    counter = 1
                                    counter2 = 1
                                    
                                    Dim message As String
                                    message = ""
                                
                                    While counter < (Len(buffer_request) + 1) And counter2 < 22
                                    
                                        DoEvents
                                
                                        If ((Mid(buffer_request, counter, 1) = Chr(27)) And (Mid(buffer_request, (counter + 1), 1) = "P")) Then
                                            message = message & Chr(13)
                                            counter = counter + 3
                                            counter2 = 5
                                        ElseIf ((Mid(buffer_request, counter, 1) = Chr(27)) And (Mid(buffer_request, counter + 1, 1) = "H")) Then
                                            message = ""
                                            counter = counter + 1
                                            counter2 = 3
                                        Else
                                            message = message & Mid(buffer_request, counter, 1)
                                            counter2 = counter2 + 1
                                        End If
                                        
                                        counter = counter + 1
                                        
                                    Wend
                                    
                                    WYNIDLabel.Caption = message
                            
                                End If
                                
                            End If
                        
                        Loop
                    
                    Else
                        MsgBox ("Erreur d'envoi de la requete")
                    End If
                Else
                    MsgBox ("Erreur de formatage de la requete")
                End If
            Else
                MsgBox ("Erreur de l'initialisation de la requete")
            End If
            
            ' Analyse de l'état de réalisation
            longueur_response = Len(buffer_response)
            ptr_response = StrPtr(buffer_response)
                                
            If ATAG_ReadInit(ptr_response, longueur_response) = -1 Then
                MsgBox ("Erreur lors de la lecture de la réponse")
            End If
            
            ' etat de realisation
            If ATAG_GetStringVal("RS", buffer_request, 1) = -1 Then
                MsgBox ("Erreur lors de la lecture de l'etat de realisation")
            End If
            
        End If
   
        ' Succes ?
        If Left(buffer_request, 1) = "0" And Not cancelled Then
            
            doPayment = transaction & "/ACCEPTED"
            
            Dim txtfile As String
            Dim strTemp As String
            
            If Len(caisse) = 3 Then Open wynidPath & "\TICKETCB." & caisse For Input As 1
            If Len(caisse) = 2 Then Open wynidPath & "\TICKETCB.0" & caisse For Input As 1
            If Len(caisse) = 1 Then Open wynidPath & "\TICKETCB.00" & caisse For Input As 1
            While Not EOF(1)
                Line Input #1, strTemp
                txtfile = txtfile & strTemp & vbCrLf
            Wend
            Close #1
          
            Printer.Print txtfile
            Printer.EndDoc
            
        Else
            If Left(buffer_request, 2) = "33" Or Left(buffer_request, 2) = "35" Then
                doPayment = transaction & "/CANCELLED"
            Else
                doPayment = transaction & "/REFUSED"
            End If
        End If
        
        ' Fermeture du client
        If SWimApiClose(instanceId, 0) = -1 Then
            MsgBox ("Erreur de fermeture du client WYNID")
        End If
      
    Else
        MsgBox ("Erreur d'ouvertue du client WYNID")
    End If

End Function
