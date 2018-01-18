# AdminStudentPanel

This Repo imitates the **Admin-Student Dashboard**. App is Divide in **Two Section** As Per user's profile:
 - Admin
 - User
 
 Both Admin and User's profile are completely modular.One user can only be either Admin or normal user.
---
 | Select profile | Admin Page | User Page |
| :------------------------------------: | :------------------------------------: | :-----------------------: |
| ![](01.png ) | ![](02.png) | ![](06.png) |

---
## About Admin profile:
* **Admin Login Details**
 - Admin login details are **hardcoded** for now, Which can be changed later 
   > admin username = sobhit2017  password = kumar2017
   
* **Admin Dashboard page**

   **Select package** type and enter the **no of Keys required** it will generate Authentication keys as per 
   selected package. Which will be stored in **SQLite database**. These Authentication Keys will **require when 
   a  New user want to Register**. When user the Authentication Key Register it Search in database to see **if 
   key matches, and if it does, Registration is validated. Or else show error Toast.**
  
 * **Package Types:**
   * 03 month
     > For 03 Month package you will generate **8 Character** long **Alphanumeric Authentication Key**
   * 06 month
     > For 06 Month package you will generate **10 Character** long **Alphanumeric Authentication Key**
   * 12 month
     > For 12 Month package you will generate **12 Character** long **Alphanumeric Authentication Key**
   
   >For e.g.  First Authentication Key in the list given to user in snapshots is **BMRIC8PZ91**
  
### SnapShots for Admin profile
| Step 1- Select Package | Step 2- Enter no of Keys | Step 3- Generate Auth Keys |
| :------------------------------------: | :------------------------------------: | :-----------------------: |
| ![](03.png ) | ![](04.png) | ![](05.png) |

---

## About User profile:
* **User Login**
  - login if have login details
* **User Register**
  - Register if not Login Already
* **Enter Authentication Key**
  - Enter Authentication Key provided by Admin
  > For e.g.  Authentication Key provided by admin in snapshots is **BMRIC8PZ91**
 

### SnapShots for User profile
| Step 1- Login | Step 2- Register | Step 3- Enter Auth Key |
| :----------------------: | :-----------------------------: | :-----------------------: |
| ![](06.png ) | ![](07.png) | ![](08.png)| !


