#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n; // lê o número de lojas

    vector<int> precos(n); // cria o vetor DEPOIS de ler n, com tamanho correto

    for (int i = 0; i < n; i++) {
        cin >> precos[i]; // lê o preço de cada loja
    }

    sort(precos.begin(), precos.end()); // ordena os preços em ordem crescente (necessário para a busca binária)

    int q;
    cin >> q; // lê o número de dias (consultas)

    while (q--) { // repete q vezes, decrementando a cada iteração
        long long m;
        cin >> m; // lê o orçamento do dia

        // upper_bound retorna um iterador para o primeiro preço MAIOR que m
        // subtraindo precos.begin() obtemos quantos preços são <= m
        int resultado = upper_bound(precos.begin(), precos.end(), (int)m) - precos.begin();

        cout << resultado << "\n"; // imprime o resultado do dia
    }

    return 0;
}
