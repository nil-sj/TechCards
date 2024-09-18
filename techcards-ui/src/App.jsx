import { useState } from 'react'
import { Button } from "@/components/ui/button"
import { ThemeProvider } from "@/components/theme-provider"
import RootLayout from './_root/RootLayout'
import { Routes, Route } from 'react-router-dom';
import Feed from './_root/pages/Feed';
import Home from './_root/pages/Home';
import Account from './_root/pages/Account';
import UserAuthPage from './_auth/UserAuthPage';
import UserPrivateRoute from './utils/UserPrivateRoute';

function App() {

  return (
    <ThemeProvider defaultTheme="dark" storageKey="vite-ui-theme">
      <Routes>
        <Route element={<UserPrivateRoute />}>
          <Route element={<RootLayout/>}>
            <Route path='/feed' element={<Feed />} />
            <Route path='/account' element={<Account />} />
          </Route>
        </Route>
        <Route index element={<Home />}/>
        <Route path='/userauth' element={<UserAuthPage />}/>
      </Routes>
    </ThemeProvider>
  )
}

export default App