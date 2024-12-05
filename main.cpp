#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Produto {
private:
    string nome;
    int codigo;
    int quantidade;
    double preco;

public:
    Produto(string n, int c, int q, double p) : nome(n), codigo(c), quantidade(q), preco(p) {}

    string getNome() const { return nome; }
    int getCodigo() const { return codigo; }
    int getQuantidade() const { return quantidade; }
    double getPreco() const { return preco; }

    void setQuantidade(int q) { quantidade = q; }
    void setPreco(double p) { preco = p; }

    void aumentarQuantidade(int q) {
        quantidade += q;
        cout << "Estoque de " << nome << " atualizado. Quantidade: " << quantidade << endl;
    }

    void diminuirQuantidade(int q) {
        if (quantidade >= q) {
            quantidade -= q;
            cout << "Estoque de " << nome << " atualizado. Quantidade: " << quantidade << endl;
        } else {
            cout << "Quantidade insuficiente para a saída!" << endl;
        }
    }
};

class Estoque {
private:
    vector<Produto> produtos;

public:
    void adicionarProduto(const Produto& p) {
        produtos.push_back(p);
    }

    Produto* encontrarProduto(int codigo) {
        for (auto& p : produtos) {
            if (p.getCodigo() == codigo) {
                return &p;
            }
        }
        return nullptr;
    }

    void exibirProdutos() {
        if (produtos.empty()) {
            cout << "Não há produtos no estoque!" << endl;
            return;
        }
        for (auto& p : produtos) {
            cout << "Código: " << p.getCodigo() << ", Nome: " << p.getNome()
                 << ", Quantidade: " << p.getQuantidade() << ", Preço: R$ " << p.getPreco() << endl;
        }
    }
};

class Funcionario {
private:
    string nome;
    int id;

public:
    Funcionario(string n, int i) : nome(n), id(i) {}

    string getNome() const { return nome; }
    int getId() const { return id; }

    void realizarEntrada(Estoque& estoque, int codigo, int quantidade) {
        Produto* p = estoque.encontrarProduto(codigo);
        if (p != nullptr) {
            p->aumentarQuantidade(quantidade);
        } else {
            cout << "Produto não encontrado no estoque!" << endl;
        }
    }

    void realizarSaida(Estoque& estoque, int codigo, int quantidade) {
        Produto* p = estoque.encontrarProduto(codigo);
        if (p != nullptr) {
            p->diminuirQuantidade(quantidade);
        } else {
            cout << "Produto não encontrado no estoque!" << endl;
        }
    }
};

class Sistema {
private:
    Estoque estoque;
    vector<Funcionario> funcionarios;

public:
    Sistema() {}

    void adicionarFuncionario() {
        string nome;
        int id;

        cout << "Digite o nome do Funcionário: ";
        cin.ignore(); 
        getline(cin, nome);

        cout << "Digite o ID do Funcionário: ";
        cin >> id;

        Funcionario f(nome, id);
        funcionarios.push_back(f);
        cout << "Funcionário " << nome << " cadastrado com sucesso!\n";
    }

    void exibirFuncionarios() {
        if (funcionarios.empty()) {
            cout << "Nenhum funcionário cadastrado!\n";
            return;
        }
        cout << "\n=== Funcionários Cadastrados ===\n";
        for (auto& f : funcionarios) {
            cout << "ID: " << f.getId() << ", Nome: " << f.getNome() << endl;
        }
    }

    void menu() {
        int opcao;
        do {
            cout << "\n=== MENU ===\n";
            cout << "1. Adicionar Produto\n";
            cout << "2. Exibir Estoque\n";
            cout << "3. Entrada de Produto\n";
            cout << "4. Saída de Produto\n";
            cout << "5. Cadastrar Funcionário\n";
            cout << "6. Exibir Funcionários Cadastrados\n";
            cout << "7. Sair\n";
            cout << "Escolha uma opção: ";
            cin >> opcao;

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    estoque.exibirProdutos();
                    break;
                case 3:
                    realizarEntrada();
                    break;
                case 4:
                    realizarSaida();
                    break;
                case 5:
                    adicionarFuncionario();
                    break;
                case 6:
                    exibirFuncionarios();
                    break;
                case 7:
                    cout << "Saindo do sistema...\n";
                    break;
                default:
                    cout << "Opção inválida!\n";
            }
        } while (opcao != 7);
    }

    void adicionarProduto() {
        string nome;
        int codigo, quantidade;
        double preco;
        cout << "Nome do Produto: ";
        cin >> nome;
        cout << "Código do Produto: ";
        cin >> codigo;
        cout << "Quantidade do Produto: ";
        cin >> quantidade;
        cout << "Preço do Produto: ";
        cin >> preco;

        Produto p(nome, codigo, quantidade, preco);
        estoque.adicionarProduto(p);
        cout << "Produto adicionado ao estoque!\n";
    }

    void realizarEntrada() {
        int codigo, quantidade;
        cout << "Código do Produto: ";
        cin >> codigo;
        cout << "Quantidade a ser adicionada: ";
        cin >> quantidade;

        int idFuncionario;
        cout << "Digite o ID do Funcionário: ";
        cin >> idFuncionario;
        Funcionario* f = encontrarFuncionario(idFuncionario);
        if (f != nullptr) {
            f->realizarEntrada(estoque, codigo, quantidade);
        } else {
            cout << "Funcionário não encontrado!\n";
        }
    }

    void realizarSaida() {
        int codigo, quantidade;
        cout << "Código do Produto: ";
        cin >> codigo;
        cout << "Quantidade a ser retirada: ";
        cin >> quantidade;

        int idFuncionario;
        cout << "Digite o ID do Funcionário: ";
        cin >> idFuncionario;
        Funcionario* f = encontrarFuncionario(idFuncionario);
        if (f != nullptr) {
            f->realizarSaida(estoque, codigo, quantidade);
        } else {
            cout << "Funcionário não encontrado!\n";
        }
    }

    Funcionario* encontrarFuncionario(int id) {
        for (auto& f : funcionarios) {
            if (f.getId() == id) {
                return &f;
            }
        }
        return nullptr;
    }
};

int main() {
    Sistema sistema;

    sistema.menu();

    return 0;
}
