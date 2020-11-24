package everest.geral;

import java.util.Calendar;

public class Data
{
    final public static int DDMMAAAA = 1;
    final public static int MMAAAA = 2;
    final public static int DIA_SEMANA_DDMMAAAA = 3;
    
    private int dia;
    private int mes;
    private int ano;
    
    public Data(int d, int m, int a)
    {
        this.setDataComoHoje();
        if (isCorreta(d,m,a))
        {
            dia = d;
            mes = m;
            ano = a;
        }
    }
    
    public Data()
    {
        this.setDataComoHoje();
    }
    
    public Data( String data )
    {
        this.setDataComoHoje();
        String[] p = data.split("/");
        if (p.length == 3)
        {
            int d = Integer.parseInt( p[0] );
            int m = Integer.parseInt( p[1] );
            int a = Integer.parseInt( p[2] );
            if (Data.isCorreta(d, m, a))
            {
                dia = d;
                mes = m;
                ano = a;
            }
        }
    }
    
    
    public int obterDia()
    {
        return dia;
    }
    
    public int obterMes()
    {
        return mes;
    }
    
    public int obterAno()
    {
        return ano;
    }
    
    public String obterExtensoMes()
    {
        String[] extMes = { "janeiro","fevereiro","março","abril",
        "maio", "junho","julho","agosto","setembro","outubro","novembro",
        "dezembro" };
        
        String extenso = "";
        if (isCorreta(dia,mes,ano))
        {
            extenso = extMes[ mes - 1 ];
        }
        return extenso;
    }
    
    public void setDataComoHoje()
    {
        Calendar c = Calendar.getInstance();
        dia = c.get( Calendar.DAY_OF_MONTH );
        mes = c.get( Calendar.MONTH ) + 1;
        ano = c.get( Calendar.YEAR );
    }
    
    public int compareTo( Data outraData )
    {
        int cont2 = this.getDiaDoSeculo();
        int cont1 = outraData.getDiaDoSeculo();
        return (cont2 - cont1);
    }
    
    public String formatarData(int formato)
    {
        /* FORMATOS
        * 1 = dd/mm/aaaa - default
        * 2 = 
        * 3 =
        */
        String dataFormatada = (dia < 10 ? "0"+dia : ""+dia )+"/"+
                               (mes < 10 ? "0"+mes : ""+mes)+"/"+ano;
        
        
        return dataFormatada;
    }
    
    public String getDiaDaSemana() 
    {        
        int dsemana = getDiaDoSeculo() % 7;
        String[] diadasemana =
        {
            "Domingo", "Segunda", "Terça", "Quarta", "Quinta", 
            "Sexta", "Sabado"
        };
        return (diadasemana[dsemana]);
    }
    
    public void avancarUmDia() 
    {
        dia++;
        if (!isCorreta(dia, mes, ano))
        {
            dia = 1;
            mes++;        
            if (!isCorreta(dia, mes, ano))
            {
                mes = 1;
                ano++;
            }
        }
    }

    public void retrocederUmDia() 
    {
        int[] udm =
        {
            31, 28, 31, 30, 31,
            30, 31, 31, 30, 31, 30, 31
        };
        if (bissexto())
        {
            udm[1] = 29;
        }
        dia--;
        if (!isCorreta(dia, mes, ano))
        {
            dia = 1;
            mes--;
            if (!isCorreta(dia, mes, ano))
            {
                mes = 12;
                ano --;
            }    
            dia = udm[mes - 1];
        }
    }
    
    public boolean bissexto()
    {
        return ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0));
    }
    

    public static boolean isCorreta(int d, int m, int a)
    {
        boolean ok = false;
        
        int[] udm = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0))
        {
            udm[1] = 29;
        }
                
        if (a > 1582)
        {
            if (m >= 1 && m <= 12)
            {
                if (d >= 1 && d <= udm[m-1] )
                {
                    ok = true;
                }
            }
        }
        return ok;
    }
    
    private int getDiaDoSeculo()
    {
        //www.inf.ufrgs.br/~cabral/Dia_do_Seculo.html
        int diaDoSeculo = (ano - 1901) * 365 + (ano - 1901) / 4 + dia + (mes - 1)
                * 31 - ((mes * 4 + 23) / 10)
                * ((mes + 12) / 15) + ((4 - ano % 4) / 4)
                * ((mes + 12) / 15);
        return diaDoSeculo;
    }
    
}
