#include <GUIConstantsEx.au3>
#include <GuiListView.au3>
#include <MsgBoxConstants.au3>

Example()

Func Example()
	Local $aPos, $idListview

	GUICreate("ListView Get Item Position", 400, 300)
	$idListview = GUICtrlCreateListView("", 2, 2, 394, 268)
	GUISetState(@SW_SHOW)

	; Add columns
	_GUICtrlListView_AddColumn($idListview, "Items", 100)

	; Add items
	_GUICtrlListView_AddItem($idListview, "Item 1")
	_GUICtrlListView_AddItem($idListview, "Item 2")
	_GUICtrlListView_AddItem($idListview, "Item 3")

	; Get item 2 position
	$aPos = _GUICtrlListView_GetItemPosition($idListview, 1)
	MsgBox($MB_SYSTEMMODAL, "Information", StringFormat("Item 2 Position : [%d, %d]", $aPos[0], $aPos[1]))

	; Loop until the user exits.
	Do
	Until GUIGetMsg() = $GUI_EVENT_CLOSE
	GUIDelete()
EndFunc   ;==>Example
