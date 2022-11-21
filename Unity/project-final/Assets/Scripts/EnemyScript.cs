using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyScript : MonoBehaviour
{
    [SerializeField]public float health = 50f;


    public void TakeDamage(float amount)
    {
        health -= amount;
        if (health<=0f)
        {
            Kill(gameObject);
        }
    }

    private void Kill(GameObject go)
    {
        Destroy(go);
    }
}
