Page Title:Trello

# Object Definitions
==================================================================================================================
txt_boardPageHeader                 classname   board-header-btn-text
lnk_existingCard		 	        xpath 		//h2[text()='${listName}']/../following-sibling::div/a/div/span[contains(text(),'%{cardName}')]
txtArea_addComment                  xpath       //h3[text()='Add Comment']/../following-sibling::div//form//textarea
btn_saveComment                     xpath       //input[@value='Save' and @class='primary confirm mod-no-top-bottom-margin js-add-comment']
text_comment                        xpath       (//p[text()='${comment}'])[2]
==================================================================================================================