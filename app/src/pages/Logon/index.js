import React, { useState }from 'react'
import { useHistory } from 'react-router-dom'

import './styles.css'

import api from '../../service/api'

export default function Logon() {

    const [exibirFormLogin, setExibirFormLogin] = useState(true)
    const [exibirFormCadastro, setExibirFormCadastro] = useState(false)
    
    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')
    const [nomeCompleto, setNomeCompleto] = useState('')
    const [cpf, setCpf] = useState('')
    const [dataNascimento, setDataNascimento] = useState('')

    const history = useHistory()

    function opcaoLogar() {
        setExibirFormLogin(true)
        setExibirFormCadastro(false)
    }

    function opcaoCadastrar() {
        setExibirFormCadastro(true)
        setExibirFormLogin(false)
    }

    async function logarUsuario(e) {
        e.preventDefault()

        try {
            const data = {
                email,
                password: senha
            }

            const response = await api.post('/public/login', data)

            localStorage.setItem("token",response.data.accessToken);

            history.push('/profile')
        } catch (error) {
            alert('Falha no login, tente novamente.')
        }
    }

    async function cadastrarUsuario(e) {
        e.preventDefault()

        try {
            const data = {
                nomeCompleto,
                email,
                senha,
                dataNascimento,
                cpf
            }

            await api.post('/usuarios', data)

            setExibirFormLogin(true)
            setExibirFormCadastro(false)
            
        } catch (error) {
            alert('Erro no cadastro, tente novamente.')
        }
    }

    return(
        <div className="logon-container">      
            <section className="buttons">
                {exibirFormCadastro && (
                    <button className="button" onClick={opcaoLogar}>
                        LOGIN
                    </button>
                )}

                {exibirFormLogin && (
                    <button className="button" onClick={opcaoCadastrar}> 
                        CADASTRE-SE
                    </button>
                )}
            </section>

            <section className="form">
                {exibirFormLogin && (
                    <form className="login" onSubmit={logarUsuario}>
                        <h1>FAÇA SEU LOGIN</h1>
                        <input 
                            placeholder="E-mail:"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />
                        <input 
                            placeholder="Senha:"
                            type="password"
                            value={senha}
                            onChange={e => setSenha(e.target.value)}
                        />
                        <button type="submit" className="button">ENTRAR</button>
                    </form>
                )}

                {exibirFormCadastro && (
                    <form className="cadastro" onSubmit={cadastrarUsuario}>
                        <h1>FAÇA SEU CADASTRO</h1>
                        <input 
                            placeholder="Nome completo:"
                            value={nomeCompleto}
                            onChange={e => setNomeCompleto(e.target.value)}
                        />
                        <input 
                            placeholder="E-mail:"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />
                        <input 
                            placeholder="Senha:"
                            type="password"
                            value={senha}
                            onChange={e => setSenha(e.target.value)}
                        />
                        <input 
                            placeholder="CPF:"
                            value={cpf}
                            onChange={e => setCpf(e.target.value)}
                        />
                        <input 
                            placeholder="Data de nascimento:(yyyy-MM-dd)"
                            value={dataNascimento}
                            onChange={e => setDataNascimento(e.target.value)}
                        />
                        <button type="submit" className="button">CADASTRAR</button>
                    </form>
                )}
            </section>
        </div>
    )
}