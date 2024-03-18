// page.js

import AddUser from './components/AddUser';
import Navbar from './components/Navbar';
import UserList from './components/UserList';

// Define your functional component
const Page = () => {
 

  return (
    <div>
      <head> 
        <title>EniCollab</title>
      </head>
      <Navbar/>
      <AddUser/>
      
    </div>
  );
};


export default Page;
