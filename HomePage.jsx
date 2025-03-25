import {Link} from 'react-router-dom';

import Signin from './Signin';

export default function HomePage(){
    return (
        <>
            <h1>Welcome to CC Class</h1>
        
            <p>Here you will learn about React</p>

            <Link to={"/Signin"}>SignIn</Link>

            

        </>
    );
}