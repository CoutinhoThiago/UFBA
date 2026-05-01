#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool check(int meio, int maxop, int mid_idx, const vector<int>& fragmentos) {
    // upper_bound acha o 1º elemento MAIOR que meio no vetor ordenado
    // subtraindo o início, obtemos quantos já são <= meio (sem custo algum)
    int cnt = upper_bound(fragmentos.begin(), fragmentos.end(), meio) - fragmentos.begin();
    // para a mediana ser <= meio, precisamos de (mid_idx + 1) elementos <= meio
    // faltantes = quantos elementos ainda faltam ser reduzidos
    int faltantes = (mid_idx + 1) - cnt;
    // se já temos elementos suficientes <= meio, não precisamos de nenhuma operação
    if (faltantes <= 0) return true;
    int custo = 0; // conta as operações necessárias
    // os elementos > meio estão nas posições cnt, cnt+1, ... do vetor ordenado
    // pegamos os "faltantes" mais baratos (os menores custam menos para reduzir)
    for (int i = cnt; i < cnt + faltantes; i++) {
        custo += fragmentos[i] - meio; // cada operação reduz 1 unidade, então custa (fragmentos[i] - meio)
        if (custo > maxop) return false; // se já passou do limite, não adianta continuar
    }
    return custo <= maxop; // retorna true se o custo total não ultrapassou o limite
}

int main() {
    vector<int> entrada(2);
    for (int i = 0; i < 2; i++) {
        cin >> entrada[i];
    }
    int nfrag = entrada[0]; // numero de de fragmentos do medalhão
    int maxop = entrada[1]; // numero maximo de operações
    
    vector<int> fragmentos(nfrag); // poder de cada fragmento
    for (int j = 0; j < nfrag; j++) {
        cin >> fragmentos[j];
    }
    
    sort(fragmentos.begin(), fragmentos.end()); // ordena em ordem crescente — obrigatório para upper_bound funcionar
    
    int mid_idx = nfrag / 2; // mediana
    
    int inferior = -20000000; // limite inferior (-2 bilhões cobre todos os casos)
    int superior = fragmentos[mid_idx]; // limite superior | mediana atual

    // busca binaria entre o menor valor possível e a mediana atual
    while (inferior < superior) {
        int meio = inferior + (superior - inferior) / 2; // ponto médio do intervalo atual

        if (check(meio, maxop, mid_idx, fragmentos)) {
            superior = meio; // o 'meio' é viavel → tenta um valor ainda menor
        } else {
            inferior = meio + 1; // o 'meio' não é viavel → sobe o limite inferior
        }
    }
    
    // se inferior == superior é o menor valor possível
    cout << inferior << "\n";
    return 0;
}