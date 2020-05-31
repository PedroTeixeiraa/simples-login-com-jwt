import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router-dom'

import './styles.css'

import imgPerfil from '../../assets/profile.png'

import api from '../../service/api'

export default function Profile() {

    const [nomeCompleto, setNomeCompleto] = useState('')
    const [email, setEmail] = useState('')
    const [cpf, setCpf] = useState('')
    const [dataNascimento, setDataNascimento] = useState('')

    const history = useHistory()

    const token = localStorage.getItem('token')

    useEffect(() => {
        api.get('/usuarios', {
            headers: {
                Authorization: token,
            }
        }).then(response => {
            const data = response.data
            setNomeCompleto(data.nomeCompleto)
            setCpf(data.cpf)
            setEmail(data.email)
            setDataNascimento(data.dataNascimento)
        })
    }, [token])

    function logout() {
        localStorage.clear()

        history.push('/')
    }

    return(
        <div className="container-perfil">

            <h1>INFORMAÇÕES DO PERFIL</h1>
            <section className="informacoes-usuario">
                <div>
                    <img src={imgPerfil} alt="imagem-perfil"/>
                    <h1>Bem vindo, {nomeCompleto}!</h1>
                </div>

                <h2>E-MAIL: {email}</h2>
                <h2>CPF: {cpf}</h2>
                <h2>DATA DE NASCIMENTO: {dataNascimento}</h2>
            </section>

            <section className="sair-perfil">
                <button className="button" onClick={logout}>SAIR DO PERFIL</button>
            </section>
        </div>
    )
}