# Trabalho Final de Metodologias e Desenvolvimento de Software

Pretende-se criar um sistema de backend para a gestão de hoteis, nomeadamente no que diz respeito à gestão dos quartos disponíveis, da manutenção dos quartos e das estadias dos hóspedes.

O sistema disponibiliza operações que permitem ao gestor criar, editar e remover quartos, especificar todas as características do quarto, incluindo a capacidade
máxima de hóspedes, o número de camas, o tipo de vista (por exemplo serra ou mar), se tem cozinha ou não, o número de casas de banho e se tem ou não varanda. Qualquer uma das propriedades pode ser alterada a qualquer momento pelo gestor do sistema. Este tipo de gestão apenas pode ser efetuado pelo gestor do sistema.

Existem também operações que permitem aos funcionários do hotel verificar quais os quartos que precisam de manutenção, que tipo de manutenção (limpeza, trocar lâmpadas, etc…), bem como registar todas as manutenções que são realizadas aos quartos. Os gestores do hotel também devem conseguir realizar estas operações.

Este sistema é também usado para fazer a gestão das reservas do hotel, disponibilizando operações que permitem registar a ocupação de cada quarto. Associado a
cada estadia, existe um registo de ocorrências, como por exemplo queixas dos hóspedes ou comportamentos menos apropriados por parte dos hóspedes, ficando associado ao histórico de cada hóspede. Estas operações estão disponíveis para qualquer utilizador do sistema.

O sistema disponibiliza operações que permitem sugerir que quartos devem ficar associados a uma reserva, de acordo com as restrições da reserva e considerando a ocupação de cada um dos quartos. Para isso, é considerado o número total de hóspedes, o número de hóspedes por quarto e o número total de quartos, a tipologia de cada quarto e as datas de entrada e de saída. Caso a sugestão do sistema seja aceite, é possível fazer a reserva de imediato. Para que uma reserva possa ser feita, os hóspedes têm que estar registados no sistema, incluindo os seus dados pessoais. As reservas podem ser realizadas pelo gestor do sistema, pelos funcionários ou pelos hóspedes, sendo que as reservas feitas pelos hóspedes devem ser confirmadas pelo gestor ou pelos funcionários.

Depois de cada estadia, é possível registar a avaliação dos hóspedes. Esta avaliação apenas pode ser feita até 1 mês depois do final da estadia.
