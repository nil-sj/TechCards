import React from 'react'
import { Outlet } from "react-router-dom";
import Topbar from '@/components/shared/Topbar';
import Sidebar from '@/components/shared/Sidebar';

const RootLayout = () => {

    return (
      <div className={`h-screen flex flex-col flex-1 pr-4 pb-4 pt-16`}>
          <Topbar />
          <div className='flex h-full'>
            <Sidebar />
            <Outlet />
          </div>
      </div>
    )
  }
  
  export default RootLayout