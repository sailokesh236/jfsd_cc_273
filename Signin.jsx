import { useNavigate } from "react-router-dom";


export default function SignIn(){


    const navigate = useNavigate();
    return (
        <>
        <h1>Sigin form</h1>
        <form onSubmit={(e)=>{
            e.preventDefault();
            if(e.target[0].value === 'admin' && e.target[1].value === 'admin')
                {
                    navigate('/Welcome');
                }else{
                    alert('Invalid credentials');
                }
        }}>
            <input type="text" />
            <input type="password" />
            <button>Sign in</button>
        </form>
        
        
        </>
    )
}