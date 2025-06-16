# Project Summary: 
Enhanced a Stateful API in Java by customizing a Spring Framework application to improve user interaction and functionality for an inventory management system.

## Implementation Steps: 
The goal of this project was to enhance an existing API. While the basic HTML and Java backend were in place, I needed to add functionality for the inventory manager to operate effectively.

I successfully enhanced the Spring application by adding a sample inventory with five parts and five products, ensuring it didn’t overwrite any existing database data. The sample inventory is stored in a set to prevent duplicates.

I created a new controller to implement a "Buy Now" button, placing it next to the update and delete buttons. This button decrements the product's inventory by one while keeping the associated parts unaffected, displaying a message that indicates the success or failure of each purchase.

To track inventory levels, I added additional fields for maximum and minimum inventory to the part entity and updated the sample inventory accordingly. I included text inputs in the relevant forms for users to set these values and modified the code to enforce inventory limits.

I implemented validation to display error messages for low inventory when adding and updating parts and products, as well as for exceeding maximum inventory levels. I also added unit tests for the maximum and minimum fields in the test package.

In the end, the computer shop now features an inventory management system that enables users to add, modify, and delete relevant persistent data.

## Detailed Change Log:

### Part C: Customize the HTML user interface for your customer’s application

- **Prompt:** Change the title of the shop
    - **File Name:** `mainscreen.html`
    - **Line Number:** 14
    - **Change:** Updated title tag from "My Bicycle Shop" to "Marko's Computer Shop"

- **Prompt:** Update main header
    - **File Name:** `mainscreen.html`
    - **Line Number:** 26
    - **Change:** Changed `<h1>` from "Shop" to "Marko's Computer Shop"

- **Prompt:** Update section header for parts
    - **File Name:** `mainscreen.html`
    - **Line Number:** 29
    - **Change:** Changed `<h2>` from "Parts" to "PC Parts"

- **Prompt:** Update section header for products
    - **File Name:** `mainscreen.html`
    - **Line Number:** 65
    - **Change:** Changed `<h2>` from "Products" to "Computers"

### Part D: Add an “About” page

- **Prompt:** Add a link to the About Us page
  - **File Name:** `mainscreen.html`
  - **Line Number:** 27
  - **Change:** Added a link to the About Us page: `<a href="about">About Us</a>`

- **Prompt:** Create the About Us page
  - **File Name:** `about.html`
  - **Line Number:** 1-15: All head content copied from `mainscreen.html`
  - **Line Number:** 14: Changed title tag to say "About Us"
  - **Line Number:** 16: Added opening `<body>` tag
  - **Line Number:** 18: Div containing the webpage content copied from home page
  - **Line Number:** 19: Added `<h1>` with text "About Us"
  - **Line Number:** 20: Added `<hr>` to create space
  - **Line Number:** 21-28: `<p>` tags explaining about us
  - **Line Number:** 29-31: `<p>` and `<a>` tags for navigation back to the home page
  - **Line Number:** 32: Closed div tag
  - **Line Number:** 33: Closed body tag

- **Prompt:** Create a controller for the About page
  - **File Name:** `AboutController.java`
  - **Line Number:** 1: Package declaration added that holds all controllers
  - **Line Number:** 3-5: Import necessary annotations
  - **Line Number:** 8: Annotation to specify the class is a controller
  - **Line Number:** 9: Create `AboutController` class
  - **Line Number:** 12-15: Create `@GetMapping` method that displays about page template

### Part E: Add a sample inventory

- **Prompt:** Add 5 parts and 5 products to the sample inventory
  - **File Name:** `BootStrapData.java`
  - **Line Number:** 40: Modified the `run` method to add sample data
  - **Line Number:** 41: Added an if statement to prevent duplicate part objects from being added
  - **Line Number:** 43: Created a `cpu` part object
  - **Line Number:** 44-48: Set properties for the `cpu` object
  - **Line Number:** 51: Added the `cpu` object to the repository
  - **Line Number:** 54: Created an `ssd` part object
  - **Line Number:** 55-59: Set properties for the `ssd` object
  - **Line Number:** 62: Added the `ssd` object to the repository
  - **Line Number:** 65: Created a `ram` part object
  - **Line Number:** 66-70: Set properties for the `ram` object
  - **Line Number:** 73: Added the `ram` object to the repository
  - **Line Number:** 76: Created a `gpu` part object
  - **Line Number:** 77-81: Set properties for the `gpu` object
  - **Line Number:** 84: Added the `gpu` object to the repository
  - **Line Number:** 87: Created a `computerCase` part object
  - **Line Number:** 88-92: Set properties for the `computerCase` object
  - **Line Number:** 95: Added the `computerCase` object to the repository
  - **Line Number:** 96: Ended the if statement that prevents duplicate part objects from being created
  - **Line Number:** 98-104: Added a for loop to print the `cpu` business name if initialized properly
  - **Line Number:** 106-108: Printed all parts and their respective company names to the log
  - **Line Number:** 111: Added an if statement to prevent multiple product objects from being added
  - **Line Number:** 112: Created a `gamingComputer` product object
  - **Line Number:** 113: Created a `miniComputer` product object
  - **Line Number:** 114: Created a `homeOfficeComputer` product object
  - **Line Number:** 115: Created a `workstationComputer` product object
  - **Line Number:** 116: Created a `budgetComputer` product object
  - **Line Number:** 117-121: Added each product object to their respective repositories in the order they were created
  - **Line Number:** 124-128: Printed the counts and details of products and parts to the console

### Part F: Add a “Buy Now” button

- **Prompt:** Add a “Buy Now” button to your product list
  - **File Name:** `mainscreen.html`
  - **Line Number:** 97-100: Added a form with a buy now button that allows users to purchase products

- **Prompt:** Display flash message when product is purchased
  - **File Name:** `mainscreen.html`
  - **Line Number:** 21-24: Page will load a success or failure message after buy now button is hit

- **Prompt:** Create a controller for the Buy Now button
  - **File Name:** `BuyNowController.java`
  - **Line Number:** 1: Package declaration added that holds all controllers
  - **Line Number:** 3-11: Import necessary annotations
  - **Line Number:** 13-14: Create a class named `BuyNowController` to handle the buy now button
  - **Line Number:** 16-17: Create an autowired `productRepository` object to handle database interaction
  - **Line Number:** 19-20: Create a `@PostMapping` method to handle buy now requests
  - **Line Number:** 22: Create an `Optional<Product>` to handle potentially null pointers
  - **Line Number:** 24: If branch created that handles if the object was found
  - **Line Number:** 25: Create a `Product` object from the `Optional<Product>` that was confirmed to be present
  - **Line Number:** 26: Nested if branch that checks if the product has an inventory greater than zero
  - **Line Number:** 27-28: If inventory was greater than 0, decrement inventory by 1 and save changes
  - **Line Number:** 29: When the page is reloaded, display a message that the purchase was successful
  - **Line Number:** 31-33: Else (inventory <= 0), display message that the product is out of stock
  - **Line Number:** 35-36: Else (product not found), display message that the product was not found
  - **Line Number:** 38: Method returns to `mainscreen.html`, effectively reloading the page with the buy now message

### Part G: Track maximum and minimum inventory

- **Prompt:** Add additional fields to the part entity for maximum and minimum inventory
  - **File Name:** `Part.java`
  - **Line Number:** 7: Imported max
  - **Line Number:** 32-35: Used `@Min` and `@Max` to create minimum and maximum inventory fields for `Part`
  - **Line Number:** 58-65: Created a constructor for `Part` object that includes minimum and maximum inventory fields

- **Prompt:** Modify the code to enforce that the inventory is between or at the min. and max. value
  - **File Name:** `Part.java`
  - **Line Number:** 115-117: Created `isInventoryValid` to ensure inventory is between the minimum and maximum value

- **Prompt:** Modify the sample inventory to include the maximum and minimum fields
  - **File Name:** `BootStrapData.java`
  - **Line Number:** 49-50: Set minimum and maximum inventory fields for CPU part object
  - **Line Number:** 60-61: Set minimum and maximum inventory fields for SSD part object
  - **Line Number:** 71-72: Set minimum and maximum inventory fields for RAM part object
  - **Line Number:** 82-83: Set minimum and maximum inventory fields for GPU part object
  - **Line Number:** 93-94: Set minimum and maximum inventory fields for computer case part object

- **Prompt:** Add additional text inputs to the form for the inventory so the user can set the max. and min. fields
  - **File Name:** `InHousePartForm.html`
  - **Line Number:** 24-25: Created an input field in the form to set the minimum inventory of `Part`
  - **Line Number:** 27-28: Created an input field in the form to set the maximum inventory of `Part`

- **Prompt:** Add additional text inputs to the form for the inventory so the user can set the max. and min. fields
  - **File Name:** `OutsourcedPartForm.html`
  - **Line Number:** 25-26: Created an input field in the form to set the minimum inventory of `Part`
  - **Line Number:** 28-29: Created an input field in the form to set the maximum inventory of `Part`

- **Prompt:** Rename the file the persistent storage is saved to
  - **File Name:** `application.properties`
  - **Line Number:** 6: File renamed to `computer-shop-h2-db`

- **Prompt:** Display minimum and maximum inventory of parts
  - **File Name:** `mainscreen.html`
  - **Line Number:** 46: Added "Minimum Inventory" table header to sample inventory table
  - **Line Number:** 47: Added "Minimum Inventory" table header to sample inventory table
  - **Line Number:** 56: Added a cell to the table which displays the minimum allowable inventory of a part
  - **Line Number:** 57: Added a cell to the table which displays the maximum allowable inventory of a part
  

   <u>***Part H Overwrites the following 2 prompts:***</u>


- **Prompt:** Modify the code to enforce that the inventory is between or at the min. and max. value
  - **File Name:** `AddInhousePartController.java`
  - **Line Number:** 44: Enter if branch if inventory is not within bounds of minimum and maximum inventory
  - **Line Number:** 45: Prepare reject message for display that the inventory was not set to an appropriate value
  - **Line Number:** 46: Reload the page where the reject message will be displayed

- **Prompt:** Modify the code to enforce that the inventory is between or at the min. and max. value
  - **File Name:** `AddOutsourcedPartController.java`
  - **Line Number:** 45: Enter if branch if inventory is not within bounds of minimum and maximum inventory
  - **Line Number:** 46: Prepare reject message for display that the inventory was not set to an appropriate value
  - **Line Number:** 47: Reload the page where the reject message will be displayed

### Part H: Add validation for inventory fields

- **Prompt:** Display error messages for low inventory when adding and updating parts
  - **File Name:** `AddInhousePartController.java`
  - **Line Number:** 45-46: If branch displays a message when inventory is below the minimum

- **Prompt:** Display error messages for low inventory when adding and updating parts
  - **File Name:** `AddOutsourcedPartController.java`
  - **Line Number:** 46-47: If branch displays a message when inventory is below the minimum

- **Prompt:** Display error messages for too large of an inventory when adding and updating parts
  - **File Name:** `AddInhousePartController.java`
  - **Line Number:** 48-49: Else branch displays a message when inventory is above the maximum

- **Prompt:** Display error messages for too large of an inventory when adding and updating parts
  - **File Name:** `AddOutsourcedPartController.java`
  - **Line Number:** 49-50: Else branch displays a message when inventory is above the maximum

- **Prompt:** Display error messages for low inventory when adding and updating products
  - **File Name:** `EnufPartsValidator.java`
  - **Line Number:** 36: Updated logic to check if removing a part causes inventory to drop below minimum

- **Prompt:** Display error messages for low inventory when adding and updating products
  - **File Name:** `ValidEnufParts.java`
  - **Line Number:** 20: Updated error message to better convey the issue 

### Part I: Unit tests for inventory fields

- **Prompt:** Add two unit tests for the maximum field and two unit tests for the minimum field of the PartTest class
  - **File Name:** `PartTest.java`
  - **Line Number:** 104-105: Added `getMinInv` to ensure the program accurately retrieves the minimum possible value of a part
  - **Line Number:** 106: Variable that is set to the lowest possible value the program will see
  - **Line Number:** 107-108: Ensures the program accurately retrieves the minimum possible value of `partIn`
  - **Line Number:** 109-110: Ensures the program accurately retrieves the minimum possible value of `partOut`
  - **Line Number:** 113-114: Added `setMinInv` to ensure the program accurately sets the minimum possible value of a part
  - **Line Number:** 115: Variable that is set to the lowest possible value the program will see
  - **Line Number:** 116-117: Ensures the program accurately sets the minimum possible value of `partIn`
  - **Line Number:** 118-119: Ensures the program accurately sets the minimum possible value of `partOut`
  - **Line Number:** 122-123: Added `getMaxInv` to ensure the program accurately retrieves the maximum possible value of a part
  - **Line Number:** 124: Variable that is set to the highest possible value the program will see
  - **Line Number:** 125-126: Ensures the program accurately retrieves the maximum possible value of `partIn`
  - **Line Number:** 127-128: Ensures the program accurately retrieves the maximum possible value of `partOut`
  - **Line Number:** 131-132: Added `setMaxInv` to ensure the program accurately sets the maximum possible value of a part
  - **Line Number:** 133: Variable that is set to the highest possible value the program will see
  - **Line Number:** 134-135: Ensures the program accurately sets the maximum possible value of `partIn`
  - **Line Number:** 136-137: Ensures the program accurately sets the maximum possible value of `partOut`

### Part J: Clean up unused validators

- **Prompt:** Remove the class files for any unused validators
  - **File Name:** `deletePartValidator`
  - **Action Taken:** Deleted file as it had no usages in the project  
