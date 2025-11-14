This app gets a user list from an external URL. The user list is stored in the cache for offline use. A search bar allows the app user to easily find a user.

Screenshots:
<img width="232" height="515" alt="Screenshot 2025-11-14 at 11 00 04 AM" src="https://github.com/user-attachments/assets/cf25db9b-0403-4d88-b684-fbe3e09e5e5d" />
<img width="234" height="520" alt="Screenshot 2025-11-14 at 11 00 22 AM" src="https://github.com/user-attachments/assets/851dc04a-2597-4135-aab9-16da8e37d742" />
<img width="234" height="519" alt="Screenshot 2025-11-14 at 11 00 50 AM" src="https://github.com/user-attachments/assets/29f84d34-c796-4e96-b178-850feb5878dc" />

Core functionalities:
The app gets data from the API using retrofit. The data is then stored in a local Room database. The app follows a offline first approach and updates the data when internet connection is available.
