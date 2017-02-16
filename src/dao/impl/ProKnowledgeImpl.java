package dao.impl;

import JavaBean.BugData;
import SpiderUtils.LevenshteinDis;
import dao.ProKnowledgeDao;
import JavaBean.ProKnowledge;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2017/2/10.
 */
public class ProKnowledgeImpl extends BaseDaoImpl<List> implements ProKnowledgeDao {
    public ProKnowledgeImpl(){
        this.setNs("com.gintongame.mapping.ProKnowledgeMapper.");
    }

    /**
     * c
     * @param proKnowledges
     */
    @Deprecated
    @Override
    public void insertBatch(List<ProKnowledge> proKnowledges) {
        this.getSqlSession().insert(this.getNs() + "insertBatch", proKnowledges);
    }



    public class FormatEexception extends Exception
    {
        public FormatEexception(String msg)
        {
            super(msg);
        }
    }


    public boolean insertBatchAutoDedup(List<ProKnowledge> proKnowledges) throws FormatEexception {
        int flag=0;
        boolean fg=true;
        for(int i=0;i<proKnowledges.size();i++){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = simpleDateFormat.parse(proKnowledges.get(i).getPtime());
            }catch (Exception e){
                throw new FormatEexception("Time format error,It should be in the form of:\"yyyy-MM-dd HH:mm:ss\"");
            }
            if(StringUtils.isEmpty(proKnowledges.get(i).getMain())){
                System.out.println("this is the null");
                proKnowledges.remove(i);
                i=i-1;
            }else if (StringUtils.isNotEmpty(proKnowledges.get(i).getMain()) && LevenshteinDis.isExist(proKnowledges.get(i).getMain(), proKnowledges.get(i).getPtime(),proKnowledges.get(i).getUrl())) {
                proKnowledges.remove(i);
                i=i-1;
                fg=false;
            }
            flag=i+1;
        }
        if(flag!=0) {
            this.getSqlSession().insert(this.getNs() + "insertBatch", proKnowledges);
        }
        return fg;
    }

    public void insert(ProKnowledge proKnowledge) throws FormatEexception {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = simpleDateFormat.parse(proKnowledge.getPtime());
            }catch (Exception e){
                throw new FormatEexception("Time format error,It should be in the form of:\"yyyy-MM-dd HH:mm:ss\"");
            }
            if (StringUtils.isNotEmpty(proKnowledge.getMain()) && !LevenshteinDis.isExist(proKnowledge.getMain(), proKnowledge.getPtime(),proKnowledge.getUrl())) {
                this.getSqlSession().insert(this.getNs() + "insert", proKnowledge);
            }


    }


    public List<ProKnowledge> selectList(String str) {
        return this.getSqlSession().selectList(getNs() + "selectList", str);
    }
}
