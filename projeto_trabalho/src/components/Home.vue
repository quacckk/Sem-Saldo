<template>
    <div>
        <form v-on:submit.prevent="addProduct">
            <p>Adicionar itens sem saldo</p>
            <p>Nome do funcionario: <input type="text" required v-model="nome"></p>
            <p>Descricao do produto: <input type="text" required v-model="descricao"></p>
            <p>Gtin do produto: <input type="number" required v-model="gtin"></p>
            <p>Quantidade de caixas do produto: <input type="number" required v-model="qtd"></p>
            <p>Endereco do produto: <input type="text" required v-model="endereco"></p>
        <button type="submit">Adicionar produto</button>
        </form>
        <div>
            <p>Produtos sem saldo</p>
            <ul>
                <li v-for="product in SemSaldo" :key="product.id">{{product.nome}},{{product.descricao}},{{product.gtin}},{{product.qtd}},{{product.endereco}}</li>
            </ul>
        </div>
    </div>
</template>

    <script>
        export default{
            data() {
                return {
                    nome: "",
                    descricao: "",
                    gtin: "",
                    qtd: "",
                    endereco: "",
                    SemSaldo: [] 
                }
            },

            mounted(){
                this.loadProduct()
            },
            methods: {
                async loadProduct(){
                    const response = await fetch("http://localhost:8080/api/semsaldo");
                    this.SemSaldo = await response.json();
                },
                async addProduct() {
                    const product = {
                        nome: this.nome,
                        descricao: this.descricao,
                        gtin: this.gtin,
                        qtd: this.qtd,
                        endereco: this.endereco
                    }

                    await fetch("http://localhost:8080/api/semsaldo",{
                        method: "POST",
                        headers: { "Content-Type": "application/json"},
                        body: JSON.stringify(product)
                    })
                    this.nome = ""
                    this.descricao = ""
                    this.gtin = ""
                    this.qtd = ""
                    this.endereco = ""

                    this.loadProduct()
                }
            }
        } 
    </script>
