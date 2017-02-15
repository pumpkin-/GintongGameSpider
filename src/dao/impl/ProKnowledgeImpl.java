package dao.impl;

import SpiderUtils.LevenshteinDis;
import dao.ProKnowledgeDao;
import JavaBean.ProKnowledge;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


    public void insertBatchAutoDedup(List<ProKnowledge> proKnowledges) throws FormatEexception {
        for(int i=0;i<proKnowledges.size();i++){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date date = simpleDateFormat.parse(proKnowledges.get(i).getPtime());
            }catch (Exception e){
                throw new FormatEexception("Time format error,It should be in the form of:\"yyyy-MM-dd HH:mm:ss\"");
            }
            if (proKnowledges.get(i).getMain() != null && proKnowledges.get(i).getMain().length() > 0 && LevenshteinDis.isExist(proKnowledges.get(i).getMain(), proKnowledges.get(i).getPtime())) {
                proKnowledges.remove(i);
            }
        }
        this.getSqlSession().insert(this.getNs() + "insertBatch", proKnowledges);

    }

    public void insert(ProKnowledge proKnowledge){
        this.getSqlSession().insert(this.getNs() + "insert", proKnowledge);
    }


    public List<String> selectList(String str) {
        return this.getSqlSession().selectList(getNs() + "selectList", str);
    }
}
