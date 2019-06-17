# Team Blue Autos Management System

The Team Blue Autos Management System is a program which permits a new or returning customer the ability to purchase, lease, or finance a pre-existing or customized vehicle and then finish the transaction with an employee from within the designated department.

The program is monolithic, that is, it first simulates the experience of the user on the client end, and then "switches" to the experience of the employer when finishing the transaction. This switch occurs once the customer has saved their vehicle.

## Installation

Download the source code and run from Eclipse.

## Usage

The program has three phases:

1) Login/User Onboarding
2) Vehicle Selection/Customization
3) Backend/Queue Processing

PHASE 1:

Customer perspective:
- choose new or existing customer
- if existing, enter e-mail address
- if new, follow the onscreen prompts and enter in relevant information
- once you have entered in personal information you will be prompted to
  select a transaction type: Pay in full, Leasing, or Financing. Follow
  the prompts onscreen and make a selection.

PHASE 2:

Customer  persepective:
- after making your selection above you will enter the vehicle selection
  portal.
- follow the prompt to select a type of vehicle you are interested in.
- Once you have made your selection, a listing of vehicles which match your
  criteria will be displayed. Example: If you chose Leasing and Sedans, only
  inventory which are sedans and are leasable will be displayed.
- you will next be prompted to select the ID of the vehicle you are interested
  in.
- once you select a vehicle, you may or may not be prompted to customize the
  vehicle. Cars paid for in full or financed may be customize. Leases are not.
- if you are customizing the vehicle, follow the onscreen prompts to change
  the color, interior, rims, and soundsystem of your vehicle.
- once you have finished customizing or not, you will be asked to save your
  vehicle. Once you save, a ticket is created and you are added to a queue.
- read the onscreen messages as they differ dependent on the time of day.
- this concludes the customer/user experience portion of the program.
	
PHASE 3:

Employee perspective:
- the screen will now display the simulated employee login screen.
- there are three options: Purchasing Dept., Leasing Dept., Financing Dept.
- you may choose any of the three options, but the transaction initiated
  during the customer portion of the program will only exists in its
  corresponding department queue.
- select the department you would like to log into
- you will be prompted to enter in a username and password pair which differ
  slightly based upon department. Here are the username/password pairs:

Purchasing Department:	
- JaneP	: Letmein
- BrianP : Letmein2

Leasing Department:
- JaneL	: Letmein
- BrianL : Letmein2

Financing Department:
- JaneF	: Letmein
- BrianF : Letmein2

- once you have successfully logged into your chosen department, the head of  the the queue for that department will be displayed. This consists of a customer and their corresponding vehicle they wish to purchase/lease/finance.
	  
- Purchasing Department: for this department, it is assumed that the customer is paying in full up front. Enter in the agreed upon final price of the car. This will settle the transaction and if there are any other items in the queue, they will be displayed in the same fashion. If not, you will be returned to the login screen.
	
- Leasing Department: if logging into this department the screen will again display the head of the queue for this department (customer/vehicle pair). You must then select from one of the three Leasing Agreements on screen. Once selected, the screen will display a calculated/suggested lease price. You will then be prompted to enter a final agreed upon price as before. Once entered, this transaction will be marked as complete and removed from the queue. Again, the next item in the queue will be presented if it exists.
	  
- Financing Department: much like the other departments, upon logging into this department you will see the head of the queue. You will then be prompted to select one of the four financing options available (24, 36, 48, or 60 months). You will then be prompted to enter the customer's credit score, annual income, and down payment amount. This information is sent to our credit department for approval. If the customer is approved you will see a message stating so, and then you will be prompted to enter in a final price, as before. Once entered, the transaction is marked as complete. If the credit department does not approve the customer, a message will be displayed on screen outlining the minimum criteria needed. The transaction will then be removed from the queue and another one displayed if exists. Otherwise, the employee will be returned to the department log in screen.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)