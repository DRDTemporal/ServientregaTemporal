package software.ragp.com.projectotemporal.models;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import software.ragp.com.projectotemporal.R;

public class AdapterE extends RecyclerView.Adapter<AdapterE.Holder> {
    List<Encargo> encargoList = new ArrayList<>();
    private OnClickListener mlistener;
    public interface OnClickListener{
        void itemClick(int position);
    }

    public AdapterE(List<Encargo> encargoList) {
        this.encargoList = encargoList;
    }

    public void setMlistener(OnClickListener mlistener) {
        this.mlistener = mlistener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        Holder holder = new Holder(view,mlistener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.connectData(encargoList.get(position));
    }

    @Override
    public int getItemCount() {
        return encargoList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView, final OnClickListener mlistener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mlistener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mlistener.itemClick(position);
                        }
                    }
                }
            });

        }

        public void connectData(Encargo encargo){
            try {

                TextView txtCampo1 = itemView.findViewById(R.id.txtCampo1);
                TextView txtCampo2 = itemView.findViewById(R.id.txtCampo2);
                TextView txtCampo3 = itemView.findViewById(R.id.txtCampo3);
                txtCampo1.setText(Integer.toString(encargo.getId()));
                txtCampo2.setText(encargo.getDestino());
                txtCampo3.setText(encargo.getDocumento());
            }catch (Exception e){

            }
        }
    }
}
