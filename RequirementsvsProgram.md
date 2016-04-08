Non-Function Requirements

In terms of speed, the wait times in our ATM are not long and it does not freeze.

The hardware has enough memory space to accommodate our ATM, there are never errors such as out of memory.

The UI is very straight forward and organized. Everything can be found aside from the back button in some slides.

The ATM does not fail during transactions providing reliability, aside from some functions not working due to a missing database.

It’s pretty robust considering it saves nothing. 

We can implement the same ATM program in other ATMs but that’s as far as portability goes. Doesn’t really apply here. 

System Functional Requirements

The system reads the card information and finds a matching account. It confirms that the pin inputted matches the 
found account. The system has a max pin tries at 5, although we don’t suspend the card. 

In terms of UI, there is a welcome screen with all of the options such as withdraw funds, print receipt, etc. 
Unfortunately we were unable to add bank promotions on the welcome screen. The withdraw and deposit screens did 
not have the back button. We did have an option for donating to charity added. 

We did add error handling in cases where there were not enough funds in the account. We didn’t add the feature to 
reduce the users balance by 1% as a service charge since it was a low priority requirement and we were short on time. 

Security was good, we didn’t do anything against system cracking but we assume that it is pretty solid and the system 
can’t be abused to do something like withdraw a million dollars even though you don’t have that in your account. When 
there was insufficient funds we didn’t display this information to the user, although the user was able to input that 
information again and money would not be taken out of the account unless the amount entered was in the account. We added an 
emergency button that would act as protection if there was a mugger, although it did so displaying a confirmation on the screen.

We weren’t able to meet the records requirement because our database was not working. Our receipts did not say anything nice.
