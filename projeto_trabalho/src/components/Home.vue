<template>
    <div>
        <form v-on:submit.prevent="addProduct">
            <p>Adicionar itens sem saldo</p>
            <p>Nome do funcionario: <input type="text" required v-model="nome"></p>
            <p>Descricao do produto: <input type="text" required v-model="descricao"></p>
            <p>Gtin do produto: <input type="number" required v-model="gtin"></p>
            <p>Quantidade de caixas do produto: <input type="number" required v-model="qtd"></p>
            <p>Endereco do produto: <input type="text" required v-model="endereco"></p>
            <label>Situação do produto: </label>
                <select v-model="situacao">
                    <option value="sem saldo">Sem saldo</option>
                    <option value="falta">Falta</option>
                </select>
                <br>
                <br>
        <button type="submit">Adicionar produto</button>
        <br>
        <br>
        <button @click="baixarExcel">Baixar em Excel</button>
        </form>
        <div>
            <p>Produtos sem saldo</p>
            <ul>
                <li v-for="product in SemSaldo" :key="product.id">{{product.nome}}, {{product.descricao}}, {{product.gtin}}, {{product.qtd}}, {{product.endereco}}, {{ product.situacao }}</li>
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
                    situacao: "",
                    SemSaldo: [] 
                }
            },

            mounted(){
                this.loadProduct()
            },
            methods: {
                async baixarExcel(){
                    const response = await fetch("http://localhost:8080/api/semsaldo/excel",{
                    method: "GET"
                    });
                    const blob = await response.blob();
                    const url = window.URL.createObjectURL(blob);

                    const a = document.createElement("a");
                    a.href = url;
                    a.download = "auditoria_dos_produtos.xlsx";
                    document.body.appendChild(a);
                    a.click();
                    a.remove();
                },
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
                        endereco: this.endereco,
                        situacao: this.situacao
                        
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
                    this.situacao = ""

                    this.loadProduct()
                }
            }
        } 
    </script>
